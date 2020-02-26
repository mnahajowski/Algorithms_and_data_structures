package Pack1;

public class Kopiec2 {


		private Node root;
		
		public Kopiec2() {
			this.root = null;
		}
		
		Node Root() {
			return root;
		}
		
		public Node add_Rec(Node current, int value) {
			if(current == null) {
				return new Node(value);
			}
			
			if(value < current.getKey()) {
				current.setLeft(add_Rec(current.getLeft(), value));
			} else {
				current.setRight(add_Rec(current.getRight(), value));
			}
			return current;
			
			
			/*
			 * ************
			 */
			
			
		}
		
		public void add(int value) {
			this.root = add_Rec(root, value);
		}
		
		public void delete(int value) {
			this.root  = delete_2(root, value);
		}
		
		public Node delete_2(Node current, int value) {
			if(current == null)
				return current;
			
			if(value < current.getKey()) {
				current.setLeft(delete_2(current.getLeft(), value));
			}
			else if ( value > current.getKey()) {
				current.setRight(delete_2(current.getRight(), value));
			}
			else {
				if(current.getRight() == null)
					return current.getLeft();
				else if (current.getLeft() == null)
					return current.getRight();
				
				current.setKey(minim_2(current.getRight()));
				
				current.setRight(delete_2(current.getRight(), current.getKey()));
			}
			
			return current;
		}
				
		public void show() {
			show_inorder(root);
			System.out.println("\n");
			show_postorder(root);
			System.out.println("\n");
			show_preorder(root);
			
		}
		
		public void show_inorder(Node current) {
			if(current != null) {
				show_inorder(current.getLeft());
				System.out.println(current.getKey() + " ");
				show_inorder(current.getRight());
			}
		}
		
		public void show_postorder(Node current) {
			if(current != null) {
				show_postorder(current.getLeft());
				show_postorder(current.getRight());
				System.out.println(current.getKey() + " ");
				
			}
		}
		
		public void show_preorder(Node current) {
			if(current != null) {
				
				System.out.println(current.getKey() + " ");
				show_preorder(current.getLeft());
				show_preorder(current.getRight());
			}
		}
		
		public int minim() {
			return minim_2(root);
		}
		
		public int minim_2(Node current) {
			if(current.getLeft() == null)
				return current.getKey();
			else
				return minim_2(current.getLeft());
			
		}
		
		public int maxim() {
			return maxim_2(root);
		}
		
		public int maxim_2(Node current) {
			if(current.getRight() == null)
				return current.getKey();
			else
				return maxim_2(current.getRight());
			
		}
		public int size() {
			return size_2 (root);
		}
		
		public int size_2(Node current) {
			
			int left = 0, right = 0;

			if(current.getLeft() != null)
				left = size_2(current.getLeft());
			
			if (current.getRight() != null) 
				right = size_2(current.getRight());
		
			return left + right + 1;
		}

		

	}
