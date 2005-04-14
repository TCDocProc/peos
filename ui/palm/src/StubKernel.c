#include <stdlib.h>
#include <StringMgr.h>
#include "StubKernel.h"
//
//stub for peos_list_models
//arguments: void
//retursn: array of process model strings
char **peos_list_models ( )
{
	char ** listElements2 = (char**) malloc (sizeof(char*)*2);
	listElements2[0] = (char *) malloc (1+strlen ("process 1"));
	strcpy (listElements2[0], "process 1\0");
	//(char*) listElements2 [0] = strdup ("process1");
	//(char*) listElements2 [1] = strdup ("process2");
	//malloc last element to null
	(char*) listElements2 [1] = NULL;
	
	return listElements2;
}
//
//stub for peos_run
//arguments: process model, reources, number of resources
//returns: pid of created process instance
int peos_run (char *process, peos_resource_t * resources, int num_resources)
{
	return 1;
}
//
//stub for peos_list_actions
//arguments: pid of instance, pointer to number of actions
//returns: peos_action_t array - action structs
peos_action_t *peos_list_actions(int pid, int *num_actions)
{
	peos_action_t * currentActions;
	//TEST: create our own peos_action_t
	currentActions = (peos_action_t *) calloc(2, sizeof(peos_action_t));
	strcpy (currentActions[0].name, "action1test");
	currentActions[0].script="blablabla";
	currentActions[0].pid=1;
	strcpy (currentActions[1].name, "action2test");
	currentActions[1].script="blablabla2";
	currentActions[1].pid=1;		
	*num_actions=2;
	return currentActions;
}
//
//stub for peos_list_instances
//arguments: none
//returns: list of started process instances
char **peos_list_instances()
{
	static char *result[10+1];
    int i;
    
    
    for (i = 0; i <= 10; i++) {
        result[i] = "test";//process_table[i].model;
    }
    result[i] = NULL;
    return result;	
}