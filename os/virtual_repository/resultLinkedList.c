/************************************************************************
 * Senior Design Project - PEOS Virtual Repository			*
 * Author : TASK4ONE							*
 * Filename : resultLinkedList.c					*
 ************************************************************************/

#include "form.h"
#include "variables.h"
#include "resultLinkedList.h"
#include <stdio.h> 
#include <stdlib.h> 
#include <string.h>
#include <stdbool.h>
#include <unistd.h>


/************************************************************************
 * Function:	printResultList						*
 *									*
 * Description:	Prints the contents of resultList.			*
 ************************************************************************/

void printResultList( resultList *listpointer )
{
	if ( listpointer == NULL )
		printf ( "result list is empty!\n" ) ;
	else
	{
    		while ( listpointer != NULL )
		{
			printf ( "%s\n", listpointer -> oneResult ) ;
			listpointer = ( resultList* ) listpointer -> link ;
		}
	}
	printf( "\n" );
}


/************************************************************************
 * Function:	printResultList						*
 *									*
 * Description:	Clears the resultList.					*
 ************************************************************************/
 
void clearResultList( resultList *listpointer )
{
	while ( listpointer != NULL )
		listpointer = ( resultList* ) removeResultItem( listpointer ) ;
}


/************************************************************************
 * Function:	printResultList						*
 *									*
 * Description:	Removes the first element in the resultList.		*
 ************************************************************************/
 
resultList* removeResultItem( resultList *listpointer )
{
	resultList *temp ;	// pointer to result list
		
	temp = ( resultList* ) listpointer -> link ;
	free( listpointer ) ;
	return temp ;
}



/************************************************************************
 * Function:	printResultList						*
 *									*
 * Description:	Adds the data at the end of the resultList.		*
 ************************************************************************/
 
resultList* addResultItem( resultList *listpointer, const char *data )
{
	resultList *lp = listpointer ;	// pointer to result list

	if ( listpointer != NULL )
	{
		while( listpointer -> link != NULL )
			listpointer = ( resultList* ) listpointer -> link ;
		
		listpointer -> link = ( struct resultList  * ) malloc ( sizeof ( resultList ) ) ;
		listpointer = ( resultList* ) listpointer -> link ;
		listpointer -> link = NULL ;
		listpointer -> oneResult = ( char * ) malloc ( ( strlen( data ) + 1 ) * sizeof( char ) ) ;
		strcpy( listpointer -> oneResult, data ) ;
		return lp ;
    	}
	else
	{
		listpointer = ( resultList* ) malloc ( sizeof ( resultList ) ) ;
		listpointer -> link = NULL ;
		listpointer -> oneResult = ( char * ) malloc ( ( strlen( data ) + 1 )  * sizeof( char ) ) ;
		strcpy( listpointer -> oneResult, data ) ;
		return listpointer ;
    	}
}