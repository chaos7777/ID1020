/* Author  @Amirhossein Namazi
 * Generated 07/09/2019
 * This code reads characters from standard input and prints them in the reverse order
 * Code implements structure of a Stack
 */


import java.util.* ;
public class Assignment2 {
	private class node{		//Creating object node
		char c;
		node next ;
	}
	
	 node first ;
	 Assignment2(){
		 this.first = null ;
	 }
	 
	 public void push(char c ) {   //Push a character to top of the Stack
		 node oldfirst = first ;
		 first = new  node ();
		 first.c = c;
		 first.next = oldfirst;
	 }
	 
	 public void display () {	// Displays the elements in the Stack
		 node temp = first ;
		 while(temp != null) {
			System.out.print("[" +temp.c + "],");
			temp = temp.next;
		//	 System.out.println();
		 }
	 }
	 public static void main(String []args) {	//Testing
		 Scanner in = new Scanner (System.in);  //Getting input from user from stdin
		 System.out.println("type your input");
		 String k =in.next();
		 Assignment2 s = new Assignment2();
		 for(int i= 0 ; i < k.length() ; i ++) {
			 s.push(k. charAt(i));   //pushing every character in the string to the stack
		 }
		s.display();  //Printing
		// s.push('c');
		 //s.push('d');
		// s.push('h');
		// s.display();
	 }
}
