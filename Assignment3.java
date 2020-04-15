/*	Author @Amirhossein Namazi
 * Generated 07/09/2019
 * 	This code Implements a generic iterable FIFO queue based on a double linked list
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
public class Assignment3<Item> implements Iterable <Item> {	
	
	private class node<Item>{	//Creating node
		Item item ;				
		node<Item> next ;	
		node <Item> prev ;
		public node (Item item) {	//Constructor for node
			this.item=item;
			node <Item>next = null ;
			node <Item> prev =null ;
		}
	}
	node<Item> first ;		//Reference to beginning of the queue 
	node<Item> tail ;		//Reference to end of the queue
	int size ;
	Assignment3(){			//Constructor for queue
		this.first=null;
		this.tail=null ;
		size = 0;
		}
		public boolean isEmpty() {	//Checks if queue is empty
			return first  == null ;
		}

		public void push(Item item) {		// Push (Enqueue) function
			node<Item> n = new node<>(item); 
			
			if(isEmpty()) {			//If queue is empty 
				first = n ;
				tail = n ;
				size ++ ;
			}
			else {				//If queue is not empty make the right references 
			n.next = first ;
			first.prev = n ;
			first = n ;
			size ++ ;
			}
			System.out.print("After push" );
			toStringgg();
		}
		
		public void pop() {		//Pop (Dequeue) function
		
			if(isEmpty())	//If queue is empty throws Exception
				throw new NoSuchElementException("list is Empty");
			else if(size == 1) {
				first=null;
				tail =null;
				size = 0 ;
				System.out.println("no element");
			}
			else {			//If not make the right references
				tail.prev.next=null ;
				tail = tail.prev ;
				size -- ;
			}
			System.out.print("After pop");
			toStringgg();
		}
			
		public void  toStringgg() {		//toString method to display the elements
			if(isEmpty())
				System.out.println("no element");
			for ( Item item : this)		//Using iterator
				System.out.print("[" + item + "] , ");
			System.out.println();
		}
		
		public Iterator <Item> iterator(){	//iterator is type Iterator and Iterator is a method of interface Iterable 
			return new Iterator<Item>() {
				node<Item> current = first ;
				
				public boolean hasNext() {	//function hasNext is a method from Iterator
					return current != null ;
				}
				
				public Item next () {		//function next is a method from Iterator
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
	
	
	public static void main (String [] args) {		//Testing
		Assignment3<String> obj = new Assignment3 <> ();
		obj.push("44");
		obj.push("55");
		obj.push("66");
		obj.pop();
		obj.pop();
	}
}
