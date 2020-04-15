/*Author @Amirhossein Namazi
 * 07/09/2019
 * This code Implements a generic iterable circular double linkedlist 
 * based on double linkedlist queue
 */
import java.util.*;
public class Assignment4 <Item> implements Iterable <Item> {
		private class node<Item>{ 		//Creating node
			Item item ;
			node<Item> next ;
			node <Item> prev ;
			
			public node (Item item) { 		//Constructor for node
				this.item=item;
				node <Item>next = null ;
				node <Item> prev =null ;
			}
		}
		node<Item> first ;	//Reference to the beginning of queue
		int size ;
		Assignment4(){   	//Constructor for queue
			this.first=null ;
			size = 0;
			}
			public boolean isEmpty() {   //Checks if queue is empty
				return first  == null ;
			}

			public void pushbeforefirst(Item item) {  //Adds an element before the first element
				node<Item> n = new node<>(item);
				
				if(isEmpty()) {   //If queue is empty
				//	n.next= n;
			//		n.prev = n ;
					first = n ;
					size ++ ;
				}
				else if(size == 1) {   //Edge case when size==1
					first.prev = n ;   //Make the correct references
					first.next = n;
					n.next = first ;
					n.prev =first;
					first = n ;
					size ++ ;
				}
				else {      //If queue is not empty and size is not 1 
				n.next = first ;
				first.prev.next= n ;
				n.prev=first.prev ;
				first.prev = n ;
				
				first = n ;
				size ++ ;
				}
				System.out.print("After Method pushbeforefirst" );
				toStringgg();
			}
			
			public void pushafterlast(Item item) { //Adds an element after the last element
				node<Item> n = new node<>(item);
			
				
				if(isEmpty()) { //If queue is empty
				//	n.next= n;
				//	n.prev = n ;
					first = n ;
					size ++ ;
				}
				else if(size == 1){  //Edge case when size is 1
					first.next = n;
					first.prev = n;
					n.prev = first;
					n.next= first;
					size ++ ;
				} 
				else {           		//In other cases
					first.prev.next=n;
					n.prev= first.prev;
					n.next=first;
					first.prev = n ;
					size ++ ;
				}
				System.out.print("After Method pushafterlast");
				toStringgg();
			}
			
			public void popfirst() {   //Removes first element from queue
				if(isEmpty())
					throw new NoSuchElementException("list is Empty");
				else if(size == 1) {
					first=null;
					size = 0 ;
					System.out.println("no element");
				}
				else {
					first.prev.next=first.next ;
					first.next.prev = first.prev ;
					first = first.next ;
					size -- ;
					
				}
				System.out.print("After Method popfirst");
				toStringgg();
				
			}
			 
			public void poplast() {  //Removes the last element in the queue
				if(isEmpty())
					throw new NoSuchElementException("list is Empty");
				else if(size == 1) {
					first=null;
					size = 0 ;
					System.out.println("no element");
				}
				else {
					first.prev.prev.next = first.prev.next;
					first.prev = first.prev.prev ;
					size -- ;
				}
				System.out.print("After Method poplast");
				toStringgg();
			
				}
			
				
			public void  toStringgg() {  //toString method for displaying
				if(isEmpty())
					System.out.println("no element");
				Iterator iterator = iterator();

				for ( int i = 0 ; i < size ; i++) //Since list is circular we loop considering the size of the queue
					System.out.print("[" + iterator.next() + "] , ");
				System.out.println();
			}
			
			public Iterator <Item> iterator(){  //Iterator is a method of Iterable
				return new Iterator<Item>() {
					node<Item> current = first ;
					
					public boolean hasNext() {
						return (current != null || current != first );
					}
					
					public Item next () {
						if (current == null)
							throw new NoSuchElementException() ;
						else {
							node<Item> n= current ;
						current = current.next ;
						return n.item ;
						}
					}
				};
			}
			
			public static void main(String []args ) {  //Testing Designing API

				Assignment4 <Integer> s = new Assignment4 <>();
				Scanner in = new Scanner(System.in);
				
				
				while(true){
				    System.out.println("Input what you want to do:");
				    System.out.println("0 to exit");
				    System.out.println("1 to add an element bofore the first ");
				    System.out.println("2 to add an element after the last");
				    System.out.println("3 to remove the element  the first");
				    System.out.println("4 to remove the element in the end");
				int  input = in.nextInt();
				    if(input == 0)
					break;
				    switch(input){
				    case 1:
					System.out.print("Input the element: ");
					s.pushbeforefirst(in.nextInt());
					break;
				  
				    case 2:
					System.out.print("Input the element: ");
					s.pushafterlast(in.nextInt());
					break;
				   
				    case 3:
					s.popfirst();
					break;
				  
				    case 4:
					s.poplast();
					break;
				    
				    default:
					break;
				    }
					    

				}


			    }
				
			/*	s.pushbeforefirst("44");
			*	s.pushafterlast("33");
			*	s.pushbeforefirst("65");
			*	s.pushbeforefirst("32");
			*	s.pushafterlast("99");
			*	s.poplast();
			*	s.popfirst();
			*/		
			}

