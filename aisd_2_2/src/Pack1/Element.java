package Pack1;

public class Element <T>{

	private T value;
	private Element next;
	private Element previous;
	
	public Element(T value) {
		this.value = value;
		this.next = null;
		this.previous = null;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public Element getNext() {
		return next;
	}
	public void setNext(Element next) {
		this.next = next;
	}
	public Element getPrevious() {
		return previous;
	}
	public void setPrevious(Element previous) {
		this.previous = previous;
	}
	
	public String toString() {
		return this.getValue() + " ";
	}
	
	
}
