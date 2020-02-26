package Pack1;

import java.util.Random;

public class Node {

	
	private int key;
	private String id;
	
	
	private Node left, right;
	
	public Node(int value) {
		this.key = value;
		this.left = null;
		this.right = null;
		
		
		//generowaie losowego stringa
		char[] cl = new char[5];	
		for(int i = 0; i < cl.length; i++) {
			cl[i]= (char)(((Math.random() * 26)) + (int)'A');  
		}
		
		this.id = new String(cl, 0, cl.length);
		
		
		
	}
	
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
	public String getId() {
		return id;
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
		return this.getId() + " "  + this.getKey();
	}
	
	
	
}
