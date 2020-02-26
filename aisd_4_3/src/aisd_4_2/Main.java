package aisd_4_2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST tree = new BST();  
		  
        tree.root = tree.add(tree.root, 13);  
        tree.root = tree.add(tree.root, 9);  
        tree.root = tree.add(tree.root, 14);  
        tree.root = tree.add(tree.root, 4);  
        tree.root = tree.add(tree.root, 10);  
        tree.root = tree.add(tree.root, 15);  
        tree.root = tree.add(tree.root, 3);  
        tree.root = tree.add(tree.root, 5);  
        tree.root = tree.add(tree.root, 6);  
        tree.preOrder(tree.root);  
  
        /* 
        		13  
        	  / 	\  
        	9 		14  
           / \ 	  	  \  
          4   10 	  15  
         / \  /   
        3   5 6     
        */

        tree.root = tree.remove(tree.root, 14);  
  
        /*
        		5  
        	   / \  
        	  4  13  
        	 /   / \  
        	3    9 15  
        		/ \  
        		6 10  
        */
        System.out.println("\nPo usunieciu");  
        tree.preOrder(tree.root);  
        
        
	}

}
