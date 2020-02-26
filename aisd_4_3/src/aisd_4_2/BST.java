package aisd_4_2;

public class BST {

	
	class Node { 
	    int key, height; 
	    Node left, right; 
	  
	    Node(int d) { 
	        key = d; 
	        height = 1; 
	    } 
	} 
	
	Node root; 
	  
    public int height(Node N) { 
        if (N == null) 
            return 0; 
  
        return N.height; 
    } 
  
    public int max(int a, int b) { 
        return (a > b) ? a : b; 
    } 
  

    public Node rightR(Node y) { 
        Node x = y.left; 
        Node T2 = x.right; 
  
        x.right = y; 
        y.left = T2; 
  
        y.height = max(height(y.left), height(y.right)) + 1; 
        x.height = max(height(x.left), height(x.right)) + 1; 
  
        return x; 
    } 
  
 
    public Node leftR(Node x) { 
        Node y = x.right; 
        Node T2 = y.left; 
  
        y.left = x; 
        x.right = T2; 
  
        x.height = max(height(x.left), height(x.right)) + 1; 
        y.height = max(height(y.left), height(y.right)) + 1; 
  
        return y; 
    } 
  
    public int getBalance(Node N) { 
        if (N == null) 
            return 0; 
  
        return height(N.left) - height(N.right); 
    } 
  
    public Node add(Node node, int key) { 
  
        if (node == null) 
            return (new Node(key)); 
  
        if (key < node.key) 
            node.left = add(node.left, key); 
        else
            node.right = add(node.right, key); 
 
        node.height = 1 + max(height(node.left), height(node.right)); 
  
        int balance = getBalance(node); 
  
        // Left Left 
        if (balance > 1 && key < node.left.key) 
            return rightR(node); 
  
        // Right Right 
        if (balance < -1 && key > node.right.key) 
            return leftR(node); 
  
        // Left Right 
        if (balance > 1 && key > node.left.key) { 
            node.left = leftR(node.left); 
            return rightR(node); 
        } 
  
        // Right Left 
        if (balance < -1 && key < node.right.key) { 
            node.right = rightR(node.right); 
            return leftR(node); 
        } 
  
        return node; 
    } 
  

    public void preOrder(Node node) { 
        if (node != null) { 
            System.out.print(node.key + " WYSOKOŚĆ " + node.height + " "); 
            preOrder(node.left); 
            preOrder(node.right); 
        } 
    } 
    
    public Node minim(Node node)  
    {  
        Node current = node;  
  
        while (current.left != null)  
        	current = current.left;  
  
        return current;  
    }  
  
    public Node remove(Node root, int key)  
    {  
        if (root == null)  
            return root;  
  
        if (key < root.key)  
            root.left = remove(root.left, key);  
  
        else if (key > root.key)  
            root.right = remove(root.right, key);  
  
        else
        {  
  
            if ((root.left == null) || (root.right == null))  
            {  
                Node temp = null;  
                if (temp == root.left)  
                    temp = root.right;  
                else
                    temp = root.left;  
  
                if (temp == null)  
                {  
                    temp = root;  
                    root = null;  
                }  
                else 
                    root = temp; 
            }  
            else
            {  
  
                //znalezenie najmniejszego wiekszego dziecka 
                Node temp = minim(root.right);  
 
                root.key = temp.key;  
  
                //usuniecie tamtego znalezionego z miejsca na ktoeym byl 
                root.right = remove(root.right, temp.key);  
            }  
        }  
  
        if (root == null)  
            return root;  
  
        root.height = max(height(root.left), height(root.right)) + 1;  
    
        int balance = getBalance(root);  
  
        // Left Left 
        if (balance > 1 && getBalance(root.left) >= 0)  
            return rightR(root);  
  
        // Left Right 
        if (balance > 1 && getBalance(root.left) < 0)  
        {  
            root.left = leftR(root.left);  
            return rightR(root);  
        }  
  
        // Right Right 
        if (balance < -1 && getBalance(root.right) <= 0)  
            return leftR(root);  
  
        // Right Left
        if (balance < -1 && getBalance(root.right) > 0)  
        {  
            root.right = rightR(root.right);  
            return leftR(root);  
        }  
  
        return root;  
    }  
}