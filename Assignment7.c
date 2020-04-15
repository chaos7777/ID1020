/*Author Amirhossein Namazi
* Generated 08/09/2019
*This is a code for a filter that checks if paranethes are balanced
*using array implementation
*first close the last opened paranthes , bracket , brace
*/
#include <stdio.h>

char c [100];  //creating an array
int size =0 ;
 void push(char last){  //adds the following character to the array
   c[size++]= last ;    //and increments the size by 1
 }
 char pop(){   //returns the last element in array
   return c[--size] ; //and decrements size by 1
 }
void main(){
  char d ;
  char temp ;

  while((d= getchar()) != EOF){  //Checks if charachter is End of File

  if (d == '{' || d == '[' || d == '(') //If d is an opener
  push (d); //save it in array

  if(d == '}' || d == ']' || d == ')'){  //if d is a closer
      temp = pop(); //get the last element i array

      switch(d){  //different cases
      case '}': //if d is a right brace
	if(temp != '{'){ // and temp is anything but a left brace
	  printf("False\n"); //its not balanced
	  return;
	}
	break;

      case ']': //if d is a right bracket
	if(temp != '['){ //and temp is not a left bracket
	  printf("False\n"); //not balanced
	  return;
	}
	break;

      case ')': // if d is a right paranthes
	if(temp != '('){ // and temp is not a left paranthes
	  printf("False\n"); // return false
	  return;
	}
	break;
      default:
	break;
      }
    }
  }
  if(size != 0)
    printf("False\n");
  else
    printf("True\n");
}
