package Pack1;


public class Element<T> {
	private T value;
	private Element next;
	
	public Element(T value) {
		this.value = value;
		this.next = null;
	}
	
	public void setNext(Element item) {
		next = item;
	}
	
	public T getValue() {
		return this.value;
	}
	
	public Element getNext() {
		return next;
	}
	@Override
	public String toString() {
		return this.value + " ";
	}
}
