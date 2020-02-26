package Pack1;

public class BinomialTree {
     
    	
   

        class Node    

        {

            int data;
            int numNodes;
            Node arr[];

            public Node(int k)

            {
                data = -1;
                numNodes = k;
                arr = new Node[numNodes+1];    

            }
            
            private int getData() {
            	return data;
            }

        }

        private Node root;
        private int order, size;

 

        public int getOrder() {
			return order;
		}


		public void setOrder(int order) {
			this.order = order;
		}


		public BinomialTree(int k)

        {
        	size = 0;
            order = k;        
            root = new Node(order);
            createTree(root);
            

        }


        private void createTree(Node r)

        {

            int n = r.numNodes;    
            
            if (n == 0)
                return;            

            for (int i = 0; i < n; i++) {

                r.arr[i] = new Node(i);
                createTree(r.arr[i]);
            }  
        }


        public void clear()

        {
            size = 0;
            root = new Node(order);
            createTree(root);

        }

        public boolean isEmpty() {

            return size == 0;
        }


        public int getSize() {
            return size;
        }


        public void insert(int val)

        {
            try {
                insert(root, val);
            }
            catch (Exception e) {
            }

        }
        
        public void insert2 (BinomialTree bt1) {
        	try
            {       		
                insert22(root, bt1);
            }
            catch (Exception e)
            {
            }
        }
        
        private void insert23(BinomialTree bt1) throws Exception{
        	if(this.getOrder() == bt1.getOrder()) {
        		insert22(root, bt1);
        	}
        	
        }
        
        
        
        private void insert22(Node r, BinomialTree newest)  throws Exception{
        	
        	if(r.data == -1) {
        		r.data = newest.root.data;
        		r.arr = newest.root.arr;
        		r.numNodes = newest.root.numNodes;
        		setSize(this.getSize() + newest.getSize());
        		throw new Exception("inserted !");
        	}
        	
        	int n = r.numNodes;
        	insert22(r.arr[n], newest);
        		
 
        	
        }

        public void setSize(int size) {
			this.size = size;
		}

		private void insert(Node r, int val) throws Exception {
            if (r.data == -1) {
            	
                r.data = val;
                size++;
                throw new Exception("inserted !");
            }

            int n = r.numNodes;        

            for (int i = 0; i < n; i++)

                insert(r.arr[i], val);

        }
        public void printTree()

        {

            printTree(root);
            System.out.println();

        }
        private void printTree(Node r)

        {
            if (r.data != -1)
                System.out.print(r.data +" ");        

            int n = r.numNodes;

            if (n == 0)
                return;

            for (int i = 0; i < n; i++)
                printTree(r.arr[i]);

        }

    }


 
