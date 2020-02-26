package Pack1;

import java.util.Random;

public class Node {

	
	private int key;
	
	
	private Node left, right;
	
	public Node(int value) {
		this.key = value;
		this.left = null;
		this.right = null;
	
		
		
	}
	
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}


	public String toString() {
		return this.getKey() + " "  + this.getKey();
	}
	
	
	
}
