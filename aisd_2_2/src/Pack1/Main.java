package Pack1;

public class Main {
	public static void main(String [] args) {
		Queue <Element>q1 = new Queue<Element>();
		System.out.println(q1.isEmpty());
		
		
		q1.EnQueue(new Element<Integer>(1));
		q1.EnQueue(new Element<Integer>(2));
		q1.EnQueue(new Element<Integer>(3));
		q1.EnQueue(new Element<Integer>(4));
		q1.EnQueue(new Element<Integer>(5));
		q1.EnQueue(new Element<Integer>(6));
		
		q1.show();
		System.out.println(q1.size());
		
		System.out.println(q1.Peek());
		
		q1.DeQueue();
		q1.show();
		System.out.println(q1.size());
		System.out.println(q1.contains(new Element<Integer>(3)));
		
		System.out.println(q1.indexOf(new Element<Integer>(3)));
		
		q1.clear();
		System.out.println(q1.size());
	}
}
