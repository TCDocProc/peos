#include <unistd.h>
#include <ctype.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "events.h"
#include "process_table.h"
#include "pmlheaders.h"
#include "graph_engine.h"
#include "process.h"


int create_process(char *model)
{
    int pid;
    int i;
    int num_resources;
    peos_resource_t *resources;


    resources = (peos_resource_t *) peos_get_resource_list(model,&num_resources);


    if (resources == NULL) {
        printf("error getting resources\n");
	return -1;
    }
    
    for(i = 0; i < num_resources; i++) {
	strcpy(resources[i].value, "$$");
    }
    
    printf("Executing %s:\n", model);
    
    if ((pid = peos_run(model,resources,num_resources)) < 0) {
	printf("couldn't create process\n");
	return -1;
    } 
    else {
	printf("Created pid = %d\n", pid);
	return 1;
    }
}


int notify(int pid, char *action, char *event)
{
    vm_exit_code status;

    if(strcmp(event, "start") == 0) {
        printf("Performing action %s\n", action);
        if ((status = peos_notify(pid, action, PEOS_EVENT_START)) == VM_ERROR 
	|| (status == VM_INTERNAL_ERROR)) {
	    printf("process executed an illegal instruction and has been terminated\n");
	    return -1;
        }
	else return 1;
    }	

    if(strcmp(event, "finish") == 0) {
        printf("Finishing action %s\n", action);
        if ((status = peos_notify(pid, action,PEOS_EVENT_FINISH)) == VM_ERROR 
	|| status == VM_INTERNAL_ERROR) {
	    printf("process executed an illegal instruction and has been terminated\n");
	    return -1;
        }
	else return 1;
    }
    
    if(strcmp(event, "suspend") == 0) {
	printf("Suspending action %s\n",action);    
        if ((status = peos_notify(pid, action,PEOS_EVENT_SUSPEND)) == VM_ERROR 
	|| status == VM_INTERNAL_ERROR) {
	    printf("process encountered an illegal event and has been terminated\n");
	    return -1;
        }
	else return 1;
    }
    
    if(strcmp(event, "abort") == 0) {
	printf("Aborting action %s\n",action);    
        if ((status = peos_notify(pid, action,PEOS_EVENT_ABORT)) == VM_ERROR 
	|| status == VM_INTERNAL_ERROR) {
	    printf("process encountered an illegal event and has been terminated\n");
	    return -1;
        }
	else return 1;
    }

    fprintf(stderr,"Unknown event\n");
    return -1;
}

int update_state() {

    int i=0;
    peos_action_t *tempalist;
    char **result = peos_list_instances();	
	
    while((i <= PEOS_MAX_PID)) {
	if (result[i] != NULL) {
	    int temp_num_actions;	
	    tempalist = peos_list_actions(i,&temp_num_actions);	
	    if(tempalist) {
                if(peos_notify(i, "dummy_action", PEOS_EVENT_RESOURCE_CHANGE) == VM_INTERNAL_ERROR) {
	            printf("Error in notifying resource change event\n");
	            return -1;
	        }
	    }
	}
	i++;
    }
    return 1;
}

int
main (int argc, char **argv)
{
    int pid;
    char *act_name;
    char *event;
    char c;
    char *res_name;
    char *res_val;
    char *model;
    opterr = 0;
    	
    c = getopt (argc, argv, "+c:n:ihr:d:u");
    if (c != -1) { 
        switch (c) {
            case 'c': {
		           if(argc != 3) {
		               fprintf(stderr, "Usage: peos -c process_file\n");
	                       exit(EXIT_FAILURE);
	                   }
			   else {
                               model = argv[2];
			       if(create_process(model) < 0) {
			           fprintf(stderr, "Could not Create Process\n");
			           exit(EXIT_FAILURE);
			       }
			       else return 1;
			   }
		           break;
		      }
		      
           case 'n': {
		         if(argc != 5) {
		             fprintf(stderr, "Usage: peos -n pid act_name start|finish|suspend|abort\n");
	                     exit(EXIT_FAILURE);
	                 }
			 else {
                             pid = atoi(argv[2]);
                             act_name = argv[3];
                             event = argv[4];
			     if(notify(pid, act_name, event) < 0) {
			         fprintf(stderr, "Could not %s action %s\n",event, act_name);
		                 exit(EXIT_FAILURE);
			     }
	                     else return 1;
			 }
			 break;
		     }
		     
	 case 'i': {
                       if(argc != 2) {
		           fprintf(stderr, "Usage: peos -i \n");
			   exit(EXIT_FAILURE);
		       }
		       else {
		           int i;
		           char **result = peos_list_instances(result);
		           if (result != NULL) {
		               for (i = 0; i <= PEOS_MAX_PID; i++) {
		                   printf("%d %s\n", i, result[i]);
		               }
			       return 1;
		           }
		           else {
		               fprintf(stderr, "error getting instances\n");
	                       exit(EXIT_FAILURE);
		           }
		       }		   
                       break;
                   }
		   
	 case 'r': {
                       if(argc != 5) {
		           fprintf(stderr, "Usage: peos -r pid resource_name resource_value\n");
			   exit(EXIT_FAILURE);
		       }
		       else {
                           pid = atoi(argv[2]);
                           res_name = argv[3];
                           res_val = argv[4];
			   if(peos_set_resource_binding(pid, res_name, res_val) < 0) {
			       fprintf(stderr, "Could not bind resources");
		               exit(EXIT_FAILURE);
			   }
	                   else return 1;
		       }		   
                       break;
                   }
		   
	 case 'd': {
                       if(argc != 3) {
		           fprintf(stderr, "Usage: peos -d pid \n");
			   exit(EXIT_FAILURE);
		       }
		       else {
                           pid = atoi(argv[2]);
			   if(peos_delete_process_instance(pid) < 0) {
			       fprintf(stderr, "Could not delete process instance\n");
		               exit(EXIT_FAILURE);
			   }
	                   else return 1;
		       }		   
                       break;
		   }

	 case 'u': {
                       if(argc != 2) {
		           fprintf(stderr, "Usage: peos -u\n");
			   exit(EXIT_FAILURE);
		       }
		       else {
			   if(update_state() < 0) {
			       fprintf(stderr, "Could not update process state\n");
		               exit(EXIT_FAILURE);
			   }
	                   else return 1;
		       }		   
                       break;
		   }

		   
	 case 'h': {
		       printf("To create a process: peos -c name_of_model_file\n");
	               printf("To start an action: peos -n process_id action_name event\n");
	               printf("Event can be: start or finish or abort or suspend\n");
	               printf("To update states of all processes (daemon simulation): peos -u \n");
	               printf("To get a list of instances: peos -i\n");
		       printf("To bind resources: peos -r pid resource_name resource_value\n");
		       printf("To delete a process: peos -d pid\n");
	               printf("To get help: peos -h\n");
		       break;
		   }	       
         
	 case '?': {
                       if (isprint (optopt))
                           fprintf (stderr, "Unknown option `-%c'.Please use peos -h for help.\n", optopt);
                       else
                           fprintf (stderr, "Unknown option character `\\x%x'.Please use peos -h for help.\n", optopt);
                       return 1;
		       break;
		   }
		
         default:
              abort ();
         }
    }
    else {
        printf("Invalid Invocation. Please type peos -h for help\n");
    }
    return 0;
}