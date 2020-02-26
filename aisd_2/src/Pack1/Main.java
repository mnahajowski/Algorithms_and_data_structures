package Pack1;

public class Main {
	public static void main(String[] args) {
		
		Stack <Element> s1 = new Stack<Element>();
		System.out.println(s1.isEmpty());
		s1.Push(new Element<Integer>(1));	
		s1.Push(new Element<Integer>(2));
		s1.Push(new Element<Integer>(3));
		s1.Push(new Element<Integer>(4));
		s1.Push(new Element<Integer>(5));
		s1.Push(new Element<Integer>(6));
		System.out.println(s1.size());
		s1.show();
		s1.Pop();
		s1.show();
		Element e1 = (Element)(s1.Peek());
		System.out.println(e1.toString());
		System.out.println(s1.contains(new Element<Integer>(2)));
		System.out.println(s1.size());
		System.out.println(s1.contains(new Element<Integer>(6)));
		System.out.println(s1.indexof(new Element<Integer>(2)));
		s1.clear();	
		System.out.println(s1.size());
	}	
}
