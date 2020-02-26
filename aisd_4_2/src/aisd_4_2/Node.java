package aisd_4_2;

public class Node {

	private String id;
    int val;       // the associated value
    int height;      // height of the subtree
    int size;        // number of nodes in subtree
    Node left, right;     // right subtree

    public Node(int value, int height, int size) {
    	this.val = value;
		this.left = null;
		this.right = null;
		
		
		//generowaie losowego stringa
		char[] cl = new char[5];	
		for(int i = 0; i < cl.length; i++) {
			cl[i]= (char)(((Math.random() * 26)) + (int)'A');  
		}
		
		this.id = new String(cl, 0, cl.length);
		this.height = height;
		this.size = size;
		
    }
}
