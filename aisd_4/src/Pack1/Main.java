package Pack1;

public class Main {

	public static void main(String [] args) {
		BST tree1 = new BST();
		tree1.add(3);
		tree1.add(5);
		tree1.add(8);
		tree1.add(6);
		tree1.add(1);
		tree1.add(11);
		tree1.add(9);
		tree1.add(13);
	//	tree1.add(13);
	//	tree1.add(3);
		
		System.out.println("Root: " + tree1.Root().toString());
		
		tree1.show();
		
		System.out.println(tree1.search(3));
		System.out.println(tree1.search(143));

		System.out.println("Minim : " + tree1.minim());
		System.out.println("Maxim : " + tree1.maxim());
		System.out.println("Rozmiar : " + tree1.size());
		
		tree1.subtree(11);
		
		System.out.println("\n \n");
		tree1.delete(5);
		tree1.show();
	}
}
