package Pack1;


public class Kopiec {
 
		private int[] Heap; 
	    private int size; 
	    private int maxsize; 
	  
	    private static final int BEGIN = 1; 
	  
	    public Kopiec(int maxsize) 
	    { 
	        this.maxsize = maxsize; 
	        this.size = 0; 
	        Heap = new int[this.maxsize + 1]; 
	        Heap[0] = Integer.MIN_VALUE; 
	    }
	    
	    public Kopiec(int [] tab, int size) {
	    	this.maxsize = 16;
	    	this.size = size-1;
	    	this.Heap = tab;
	    }
	  

	    // zwracamy adres rodzica wezla w zaleznosci od jego pozycji
	    private int parent(int index) 
	    { 
	        return index / 2; 
	    } 
	  
	    // zwracamy lewe dzieckp
	    private int leftChild(int index) 
	    { 
	        return (2 * index); 
	    } 
	  
	    // zwracamy prawe dziecko
	    private int rightChild(int index) 
	    { 
	        return (2 * index) + 1; 
	    } 
	  
	    // sprawdzamy czy jest to lisc
	    
	    private boolean Lisc(int index) 
	    { 
	        if (index >= (size / 2) && index <= size) { 
	            return true; 
	        } 
	        return false; 
	    } 
	    
	  
	    public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

	    private void swap(int index1, int index2) 
	    { 
	        int tmp; 
	        tmp = Heap[index1]; 
	        Heap[index1] = Heap[index2]; 
	        Heap[index2] = tmp; 
	    } 
	  
	    private void Repair(int index) 
	    { 
	  

	    	// jeżeli nie jest liściem i jest większy niż jakikolwiek ze swoich dzieci
	        if (!Lisc(index)) { 
	            if (Heap[index] > Heap[leftChild(index)] || Heap[index] > Heap[rightChild(index)]) { 
	  

	            	// zmiana z lewym i repair od lewego
	                if (Heap[leftChild(index)] < Heap[rightChild(index)]) { 
	                    swap(index, leftChild(index)); 
	                    Repair(leftChild(index)); 
	                } 
	  

	                // zmiana z prawym i repair od prawego
	                else { 
	                    swap(index, rightChild(index)); 
	                    Repair(rightChild(index)); 
	                } 
	            } 
	        } 
	    } 
	  
	   
	    public void insert(int element) 
	    { 
	        Heap[++size] = element; 
	        int current = size; 
	  
	        while (Heap[current] < Heap[parent(current)]) { 
	            swap(current, parent(current)); 
	            current = parent(current); 
	        } 
	    } 
	  
	    public void show() 
	    { 


	        for (int i = 1; i <= size / 2; i++) { 
	            System.out.print(" RODZIC: " + Heap[i] 
	                     + " LEWE DZIECKO: " + Heap[2 * i] 
	                   + " PRAWE DZIECKO:" + Heap[2 * i + 1]);
	            System.out.println(); 
	        } 
	    } 


	    public void Kopiec2() 
	    { 
	        for (int index = (size / 2); index >= 1; index--) { 
	            Repair(index); 
	        } 
	    } 
	  
	    // usuwamy pierwszy (najmniejszy)
	    public int remove() 
	    { 
	        int x = Heap[BEGIN]; 
	        Heap[BEGIN] = Heap[size--]; 
	        Repair(BEGIN); 
	        return x; 
	    } 
	  
	    // trzeba zaczynac od pierwszego bo pozniej 2*index
	    public static void main(String[] arg) 
	    { 
	        Kopiec Kopiec = new Kopiec(15); 
	        Kopiec.insert(10); 
	        Kopiec.insert(6); 
	        Kopiec.insert(34); 
	        Kopiec.insert(20); 
	        Kopiec.insert(164); 
	        Kopiec.insert(38); 
	        Kopiec.insert(12); 
	        Kopiec.insert(44); 
	        Kopiec.insert(18);
	        Kopiec.Kopiec2(); 
	       
	        
	  
	        int arr[] = {0, 10, 6, 34, 18, 164, 38, 12, 44, 20}; 
	        Kopiec kopiec2 = new Kopiec(arr,arr.length);
	        kopiec2.Kopiec2();
	        Kopiec.show(); 
	        System.out.println();
	        kopiec2.show();
	        
	    } 
	
	}