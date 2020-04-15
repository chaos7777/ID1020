//
//  main.c
//  Lab1Assignment1
// This code reads from stdin until new line character and prints characters in reverse order using
// two function. Recursive and and iterative
//  Created by Amirhossein on 2019-09-05.
//  Copyright © 2019 Amirhossein. All rights reserved.
//

#include <stdio.h>

void Rec (){  //Recursive function
    char c ;
    if ((c = getchar()) != '\n') //if not a new line character
        Rec(); //recursion
    putchar(c); //display the character
        }
void Iter (){ //Iterative function
    int i = 0;
    int j = 0;
    char a [10];    //make a fixed array
    while ( (a[i] = getchar()) != '\n'){       //finding the position of newline
        i++ ;                           //and saving it in variable i
            }
   
    for ( j = i ; j >= 0 ; j--){        //printing in reverse order
        putchar(a[j]) ;
        
    }
    
}

int main(int argc, const char * argv[]) {  //Testing
    Rec();
    Iter();
    
}
