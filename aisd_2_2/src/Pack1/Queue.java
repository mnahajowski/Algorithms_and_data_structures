package Pack1;

import java.util.NoSuchElementException;



public class Queue <T>{

	private Element head = null;
	private Element tail = null;
	private int counter = 0;
	
	public Queue() {
		
		this.head = null;
		this.tail = null;
		this.counter = 0;
	}
	
	public int size() {
		return counter;
	}
	
	public boolean isEmpty() {
		return head == null && tail == null;
	}
	
	public void clear() {
		
		head = null;
		tail = null;
		counter = 0;
	}
	
	public void EnQueue(Element item) {
		
		if(head == null && tail == null) {
			
			head = item;
			tail = item;
			head.setNext(tail);
			tail.setPrevious(head);
			
		} else{
			
			tail.setNext(item);
			item.setPrevious(tail);
			tail = tail.getNext();
			
		}
		
		counter++;
	}
	
	public void DeQueue() throws NoSuchElementException{
		
		if(!this.isEmpty()) {	
			(head.getNext()).getNext().setPrevious(head.getNext());
			head = head.getNext();	
		}
		else
			throw new NoSuchElementException();
		
		counter--;
	}
	
	public Element Peek() throws NoSuchElementException{
		
		if(!this.isEmpty())
			return head;
		
		else
			throw new NoSuchElementException();
	}
	
	public void show() {
		
		if(this.isEmpty()) 
					System.out.println("Kolejka jest pusta");
			
		else if(head == tail) 
					System.out.print(head.toString() + " ");
			
		else {			
			Element e1 = head;
			
			while(e1 != null) {
				System.out.print(e1.toString());
				e1 = e1.getNext();		
			}
		}	
		System.out.println();
	}
	
	public boolean contains(Element item) {
		if(this.isEmpty()) {
			System.out.println("Kolejka jest pusta");
			return false;
		} else {
			
			Element temp = head;
			while(temp.getNext() != null) {
				if(temp.getValue() == item.getValue())
					return true;
				
				temp = temp.getNext();
			}
			return false;
		}
	}
	
	public int indexOf(Element item) {
		if(this.isEmpty()) {
			System.out.println("Kolejka jest pusta");
			return -1;
		}
		else {
			int counter = 0;
			Element temp = head;
			
			while(temp.getNext() != null) {
				if(temp.getValue() == item.getValue())
					return counter;
				else {
					temp = temp.getNext();
					counter++;
				}
			}
			return -1;
		}
	}
	
}
