/*Author @Amirhossein Namazi
 * Generated 08/09/2019
 * This code implements an ordered queue based on double linkedlist
 */
import java.util.NoSuchElementException;
public class Assignment6 {
	

		private class node{  //Making node
			int data ;
			node next ;
			node  prev ;
			public node (int data) { //node constructor
				this.data=data;
				node next = null ;
				node  prev =null ;
			}
		}
		node first ;  //References to the beginning and end of the queue
		node tail ;
		int size ;
		Assignment6(){  //Constructor for queue 
			this.first=null;
			this.tail=null ;
			size = 0;
			}
			public boolean isEmpty() {  //Checks if empty
				return first  == null ;
			}

			public void SortedPush(int data) { //Method for sorted adding to the queue
				node  n = new node (data);
				
				if(isEmpty()) { //If queue is empty make a new node
					first = n ; //fix the references
					tail = n ;
					size ++ ;
				}
				else if( n.data <= first.data){  //If new node has to be inserted before the first node
				
				first.prev = n ;
				n.next = first ;
				first = n ;
				size ++ ;
				}
				
					else {	    		//When new node has to be inserted after the first node
			node current = first;
	         while (current.next != null && current.next.data < n.data)  //Finding the node where new node
	             	current = current.next; 					//has to be inserted after
	                
	                
	           if(current == tail && current.data < n.data) { //Edge case when new node should be added after the last
	              n.prev = current;
	              current.next = n;
	              tail = n ;
	              size ++ ;
	              }
	           
	               else{    //If new node should be added somewhere in the queue but not last
	                n.next = current.next;
	                n.prev = current ;
	                current.next.prev = n;
	                current.next = n ;
	                size ++ ;
	         		}
				}
			
				System.out.print("After push" );
				toStringgg();
				System.out.println();
			}
			
			public void pop() {  //Dequeue
				if(isEmpty())
					throw new NoSuchElementException("list is Empty");
				else if(size == 1) {
					first=null;
					tail =null;
					size = 0 ;
					System.out.println("no element");
				}
				else {
					tail.prev.next=null ;
					tail = tail.prev ;
					size -- ;
				}
				System.out.print("After pop");
				toStringgg();
				System.out.println();
			}
				
			public void  toStringgg() {  //toString for displaying
				if(isEmpty())
					System.out.println("no element");
				
				node temp = first ;
				while(temp != null) {   
					System.out.print("[" + temp.data + "] , "); //showing the integer value of node
				temp = temp.next ; //updating the reference(going to the next node)
				}
			}
		
		
		
		public static void main (String [] args) { //Testing
			Assignment6 obj = new Assignment6 ();
			obj.SortedPush(5);
			obj.SortedPush(6);
			obj.SortedPush(3);
			obj.SortedPush(4);
			obj.SortedPush(10);
			obj.pop();
			obj.SortedPush(11);
			obj.SortedPush(9);
			obj.SortedPush(8);
			obj.SortedPush(16);
			obj.SortedPush(1);
		}
	}
