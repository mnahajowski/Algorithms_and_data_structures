package Pack1;

import java.util.NoSuchElementException;

public class Stack <T>{

	private Element top = null;
	private int counter = 0;
	
	public Stack() {
		
		this.top = null;
		this.counter = 0;
	}
	
	public boolean isEmpty() {
		if(top == null)
			return true;
		
		return false;
	}
	
	public int size() {
		
		return counter;
	}
	
	public void clear() {
	
		top = null;
		this.counter = 0;
	}
	
	public Element Peek() throws NoSuchElementException{
		
		if(!this.isEmpty())
			return top;
		
		else throw new NoSuchElementException();
	}
	
	public void Push(Element item) {
		
		if(top == null) 
			top = item;
		
		else {
			item.setNext(top);
			top = item;	
		}
		
		counter++;
	}
	
	public void Pop() throws NoSuchElementException{
		
		if(this.isEmpty())
			throw new NoSuchElementException();
		
		else {
			top = top.getNext();
			counter--;
		}
	}
	
	public boolean contains (Element item) {
		
		if(top == null) {		
			System.out.println("Pusty stos");
			return false;
		}
		
		else {		
			Element e1 = top;
			while(e1 != null) {
				
				if(e1.getValue() == item.getValue())
					return true;			
				else
					e1 = e1.getNext();
				
			}
			return false;
		}
	}
	
	public void show() {
		
		if(top == null) 
			System.out.println("Pusty stos"); 
		
		else {
			
			Element e1 = top;
			
			while(e1 != null) {
				System.out.print(e1.getValue() + " ");
				e1 = e1.getNext();
			}
			
			System.out.println();;
		}
	}
	
	public int indexof(Element item) {
		
		int counter = 0;
		
		if(top == null) {
			System.out.println("Stos jest pusty");
			return -1;
		}else {		
			Element e1 = top;
			while(e1 != null) {
				
				if(e1.getValue() == item.getValue()) 
					return counter;
				
				else {
					e1 = e1.getNext();
					counter++;
				}
			}
			return -1;
		}

			
	}
}
