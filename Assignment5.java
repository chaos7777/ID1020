/*Author @Amirhossein Namazi
 * Generated 08/09/2019
 * This code implements a generalized queue which allows the user to remove the kth element in the queue
 * based on double linkedlist queue
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Assignment5 <Item> implements Iterable <Item> {
	private class node<Item>{  //Creating node
		Item item ;
		node<Item> next ;
		node <Item> prev ;
		public node (Item item) {  //node Constructor
			this.item=item;
			node <Item>next = null ;
			node <Item>prev = null ;
			
		}
	}
	node<Item> first ;  //References to the beginning and end of the list
	node<Item> tail ;
	int size ;
	Assignment5(){    // Constructor for queue
		this.first=null;
		this.tail=null ;
		size = 0;
		}
		public boolean isEmpty() {  //Checks if queue is empty
			return first  == null ;
		}

		public void push(Item item) {  //Adds element to the queue (Enqueue)
			node<Item> n = new node<>(item);
			if(isEmpty()) {
				first = n ;
				tail = n ;
				size ++ ;
			}
			else {
			n.next = first ;
			first.prev = n ;
			first = n ;
			size ++ ;
			}
			System.out.print("After push" );
			toStringgg();
		}
		
		public void pop() {  //Removes element from the queue(Dequeue)
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
		}
		
		public void removeAtpos(int k ) {  //This method removes element and the k-th position
			if(k > size )
				throw new NoSuchElementException("there is no element in this position");
			
			if (k == 1) {       //When it is the first element
				first = first.next ;
				first.prev = null ;
				size -- ;
			}
			
			else if (k == size) {   //When it is the last element(same as Dequeue (pop))
				tail.prev.next=null ;
				tail = tail.prev ;
				size -- ;
			}
			
			//else {
			//	if(k > (size/2)) {
			//		node n = tail ;
			//		for(int i = size ; i > k+1 ; i --) 
			//		n = n.prev ;
			//		n.prev = n.prev.prev ;
			//	n.prev.prev.next = n.prev.next ;
			//		size -- ;
			//	}
				else {			//other cases
			node n = first ;  //Copying a reference to first
			for (int i = 1 ; i < k - 1 ; i ++) //finding the position of the element which should be removed
			n = n.next ;
			n.next.next.prev = n.next.prev ;
			n.next = n.next.next ;
			size -- ;
				}
			
			System.out.print("After Method remove at pos" + k);
			toStringgg();
		}
		
		public void  toStringgg() {  //toString method
			if(isEmpty())
				System.out.println("no element");
			Iterator iterator = iterator();  // Making a new Iterator

			for ( int i = 0 ; i < size ; i++)
				System.out.print("[" + iterator.next() + "] , "); //looping with the size of the queue
			System.out.println();
		}
		
		public Iterator <Item> iterator(){  //implementing methods for Iterator
			return new Iterator<Item>() {
				node<Item> current = first ;
				
				public boolean hasNext() {
					return current != null ;
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
	
		public static void main(String []args) {   //Testing
			Assignment5 <String> s = new Assignment5 <>();
			s.push("5");
			s.push("7");
			s.push("2");
			s.push("6");
			s.push("9");
			s.push("10");
			s.removeAtpos(6);
		//	s.pop();
		//	s.removeAtpos(2);
			s.removeAtpos(3);
			s.removeAtpos(10);
		}

}
