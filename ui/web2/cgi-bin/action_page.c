#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "../../../os/kernel/events.h"
#include "../../../os/kernel/vm.h"
#include "../../../os/kernel/process_table.h"

void get_script(int pid, char *action);

int main()
{
  char *input, *temp, *action, *state;
  int pid;

  input = getenv("QUERY_STRING");

  printf("%s%c%c\n","Content-Type:text/html;charset=iso-8859-1",13,10);
  printf("<html>\n");
  printf("<head>\n");
  printf("<style type=\"text/css\">\n");
  printf("<!--\n");
  printf(".myTable {\n");
  printf("background-image:url(../images/bg_logoblack.jpg);\n");
  printf("background-repeat:no-repeat;\n");
  printf("background-position:left top; }\n");
  printf("-->\n");
  printf("</style>\n");
  printf("</head>\n");
  printf("<body class=\"myTable\" text=\"FFFFFF\" link=\"#FFCC66\" vlink=\"#FFCC66\">\n");

  temp = strtok(input,"+");
  pid = atoi(temp);
  temp = strtok(NULL, "=");
  action = temp;
  temp = strtok(NULL, "");
  state = temp;

  printf("<br><br><br><br>\n");
  printf("<table width=\"950px\">\n");
  printf("<tr>\n");
  printf("<td width=\"100\"></td>\n");
  printf("<td width=\"850\">\n");
  printf("<font size=\"6\"><b>Action: %s   (%s)</b></font>\n", action, state);
  printf("<br><br>\n");
  printf("<font size=\"5\">Resources</font>\n");
  printf("<br><br>\n");
  printf("<font size=\"5\">Description</font>\n");
  printf("<br>\n");
  get_script(pid, action);

  printf("<br><br><br><br>\n");
  printf("<table width=\"800\">\n");
  printf("<tr>\n");
  if(strcmp(state,"active") == 0) {
    printf("<td width=\"100\">\n");
    printf("<a href=\"do.cgi?%d+%s=done\"><img src=\"../images/done_button.jpg\" width=\"80\" height=\"25\" border=\"0\"></a>\n", pid, action);
    printf("</td>\n");
    printf("<td width=\"100\">\n");
    printf("<a href=\"do.cgi?%d+%s=suspend\"><img src=\"../images/suspend_button.jpg\" width=\"80\" height=\"25\" border=\"0\"></a>\n", pid, action);
  }
  else if(strcmp(state, "suspend") == 0) {
    printf("<td width=\"100\">\n");
    printf("<a href=\"do.cgi?%d+%s=resume\"><img src=\"../images/perform_button.jpg\" width=\"80\" height=\"25\" border=\"0\"></a>\n", pid, action);
  }
  else if(strcmp(state, "ready") == 0) {
    printf("<td width=\"100\">\n");
    printf("<a href=\"do.cgi?%d+%s=run\"><img src=\"../images/perform_button.jpg\" width=\"80\" height=\"25\" border=\"0\"></a>\n", pid, action);
  }
  else {
    printf("Error in action state.\n");
  }
  printf("</td>\n");
  printf("<td>\n"); 
    printf("<a href=\"main.cgi\"><img src=\"../images/back_button.jpg\" width=\"80\" height=\"25\" border=\"0\"></a>\n");
  printf("</td>\n");
  printf("</tr>\n");
  printf("</table>\n");
  
  printf("</td>\n");
  printf("</tr>\n");
  printf("</table>\n");

  printf("</body>\n");
  printf("</html>\n");











  return 0;
}

void get_script(int pid, char *action)
{
  char *script;
  
  load_proc_table("proc_table.dat");
  script = (char *) get_field(pid, action, ACT_SCRIPT);
  save_proc_table("proc_table.dat");
  if(script) {
    printf("<p>%s</p>\n", script);
  }
  else {
    printf("No Script\n");
  }
}
