#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <check.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include "action.h"
#include "process.h"
#include "events.h"
#include "test_util.h"


/* Stub (bogus) globals. */


/* Globals. */
char *instance_dir = NULL;
int create_instance_result = 1;
int handle_action_result = VM_DONE;



/* Stubs. */

char *find_model_file(char *model)
{
    return TEST_PROC_NAME;
}

void log_event(char *msg)
{
    return;
}


char *get_script(int pid, char *action_name)
{
    return "script";
}

peos_resource_t *get_resource_list(char *model, int *num_res)
{
    peos_resource_t *resources;	
    return resources;
}

peos_resource_t *get_resource_list_action(int pid,char *act_name, int *num_res)
{
    peos_resource_t *resources;	
    return resources;
}

peos_resource_t *get_resource_list_action_requires(int pid,char *act_name, int *num_res)
{
    peos_resource_t *resources;	
    return resources;
}


peos_resource_t *get_resource_list_action_provides(int pid,char *act_name, int *num_res)
{
    peos_resource_t *resources;	
    return resources;
}

int peos_create_instance(char *model,peos_resource_t *resources,int num_resources)
{
    return create_instance_result;
}

vm_exit_code handle_action_change(int pid, char *act, vm_act_state state) 
{
    return handle_action_result;
}


START_TEST(test_list_models)
{
    int i, failed = 0;
    char *model_dir = "test_models";
    char **models = NULL;

    /* Pre: COMPILER_DIR points to directory with models. */
    setenv("COMPILER_DIR", model_dir, 1);
    mkdir("test_models", S_IRUSR|S_IWUSR|S_IXUSR);
    for (i = 0; i < 10; i++) {
	FILE *modelf;
	char filename[256];

	sprintf(filename, "%s/%d.pml", model_dir, i);
	modelf = fopen(filename, "w");
	fprintf(modelf, "%s", "process s { action a {} }");
	fclose(modelf);
    }

    /* Action. */
    models = peos_list_models();

    /* Post: A list of all model file names in directory. */
    for (i = 0; i < 10; i++) {
	char filename[256];

	sprintf(filename, "%d",  i);
	if (strcmp(models[i], filename) != 0) {
	    char msg[BUFSIZ];
	    sprintf(msg, "model file %s not found (%s)", filename, models[i]);
	    fail(msg);
	    failed = 1;
	}
    }

    if (!failed) {
	char cmd[BUFSIZ];

	sprintf(cmd, "rm -r %s", model_dir);
	system(cmd);
    }
}
END_TEST

START_TEST(test_run_process)
{
    char *model = "test.pml";
    peos_resource_t *resources;
    int num_resources;

    /* Pre: Because load_actions() and find_model_file are stubs,
     * there are no actual pre conditions.
     */
	fail_unless(peos_run(model,resources, num_resources) != 0, 
		    "failed to create instance");
}
END_TEST


int
main(int argc, char *argv[])
{
    int nf;
    SRunner *sr;
    Suite *s = suite_create("events");
    TCase *tc;

    parse_args(argc, argv);

    tc = tcase_create("list_models");
    suite_add_tcase(s, tc);
    tcase_add_test(tc, test_list_models);



   tc = tcase_create("run");
    suite_add_tcase(s, tc);
    tcase_add_test(tc, test_run_process);

    sr = srunner_create(s);

    srunner_set_fork_status(sr, fork_status);

    srunner_run_all(sr, verbosity);
    nf = srunner_ntests_failed(sr);
    srunner_free(sr);
    suite_free(s);
    if (nf == 0) {
	/* Clean up. */
	/* system("rm -r test_instances");*/
	return EXIT_SUCCESS;
    } else {
	/* Leave evidence. */
	return EXIT_FAILURE;
    }
}
