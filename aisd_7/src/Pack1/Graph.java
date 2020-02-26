package Pack1;

import java.awt.geom.Ellipse2D;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Collections;
import java.util.List;

import java.util.PriorityQueue;
public class Graph {

	private int skier;
	private int waz;
	private LinkedList<Point> points = new LinkedList<Point>();
	private int pointCounter;
	
	int grp[][];
	
	public Graph(int skier, int waz) {
		this.skier = skier;
		this.waz = waz;
		
	}
	// tworzenie grafu skierowanego o n wierzcholkach
	public void tworzenie(int n) {
		for(int i = 0; i < n; i++) {
			points.add(new Point(i, i));
		}
		pointCounter = n;
	}
	
	public void add_point(int value) {
		points.add(new Point(pointCounter, value));
		pointCounter++;
	}
	public void add_point(Point p1, int value) {
		points.add(new Point(p1.getNumber(), value));
		pointCounter++;
	}
	
	
	public void add_point(Point p1) {
		points.add(p1);
		pointCounter++;
	}
	
	public void toTablica() {
		grp = new int[pointCounter][pointCounter];
		for(Point p1 : points) {
			for(Edge e1 : p1.getEdgeList()) {
				grp[e1.getBegin().getNumber()][e1.getEnd().getNumber()] = e1.getWeight();
			}
		}
	}
	
	// usuwa wierzcholek o indeksie n wraz z wszystkimi polaczeniami biegnacymi w jego strone
	
	public void removePoint(int n) {
		if(n < pointCounter) {
			points.set(n, null);
			for(Point p1 : points) {
				if(p1 != null)
					p1.removeEdge(n);
			}
		}
	}
	
	public void removePoint(Point p1) {
		removePoint(p1.getNumber());
	}
	
	public void addEdge(Edge e) {
		points.get( e.getBegin().getNumber() ).addEdge( e );

	}
	
	public void addEdge2(Edge e) {
		for(Point p1 : points) {
			if(p1.getNumber() == e.getBegin().getNumber())
				p1.addEdge(e);
		}
	}
	
	public int getSkier() {
		return skier;
	}
	public void setSkier(int skier) {
		this.skier = skier;
	}
	public int getWaz() {
		return waz;
	}
	public void setWaz(int waz) {
		this.waz = waz;
	}
	public LinkedList<Point> getPoints() {
		return points;
	}
	public void setPoints(LinkedList<Point> points) {
		this.points = points;
	}
	public int getPointCounter() {
		return pointCounter;
	}
	public void setPointCounter(int pointCounter) {
		this.pointCounter = pointCounter;
	}
	public void addEdge(int begin, int end, int weight) {
		if(begin >= 0 && begin <= pointCounter && end >= 0 && end <= pointCounter && points.get(begin) != null && points.get(end) != null)
			addEdge(new Edge(points.get(begin), points.get(end), weight));
	}
	
	public void removeEdge(int begin, int end) {
		if( begin >= 0 && begin <= pointCounter && points.get(begin) != null)
			points.get(begin).removeEdge(end);
	}
	
	public void removeEdge(Edge e) {
		if(e.getBegin() == null)
			return;
		
		int begin = e.getBegin().getNumber();
		if(begin >= 0 && begin <= pointCounter && points.get(begin) != null) 
			points.get(begin).removeEdge(e.getEnd().getNumber());
	}
	
	public Point getPoint(int n) {
		return points.get(n);
	}
	
	public void showEdges() {
		for(Point p : points) {
			p.showEdges();
		}
	}
	
	public void showPoints() {
		System.out.print("Punkty : ");
		for(Point p : points) {
			System.out.print(p.toString());
		}
		System.out.println();
	}
	
	
	public LinkedList<Point> getPointsList() {
		return new LinkedList<Point>(points);
	}
	
	public void degreeInput(int p1) {
		if(p1 <= pointCounter) {
			int counter = 0;
			Point p5 = new Point(this.getPoint(p1));
			for(Point pp : points) {
				counter += pp.degreeInput(p5);
			}
			System.out.println("Wchodzi do niego tyle sciezek : " + counter);
		}
		else
			System.out.println("Nie ma takiego punktu");
	}
	
	public void degreeOutput(int p1) {
		if(p1 <= pointCounter) {
			this.getPoint(p1).degreeOutput();
		}
		else
			System.out.println("Nie ma takiego punktu");
	}
	
	public void showSiblings(int p1) {
		if(p1 <= pointCounter) {
			Point p5 = new Point(this.getPoint(p1));
			p5.showSiblings();
			for(Point p2 : points) {
				p2.checkSiblings(p5);
			}
			System.out.println();
		}
	}
	
	/*
	public void minimumSpanningTree() {
		
		ArrayList <Edge> edges= new ArrayList<Edge>();
		
		for(Point p1 : points) {
			LinkedList<Edge> edges3 = new LinkedList<Edge>();
			edges3 = p1.getEdgeList();
			for(Edge e1 : edges3) {
				edges.add(e1);
			}
		}
		
		ArrayList <Edge> edges2 = new ArrayList<Edge>();
		
		Collections.sort(edges, Edge.EdgeComparator);
		
		for(Edge e2 : edges) {
			System.out.println(e2.toString());
		}
		System.out.println();
		
		ArrayList <Point> done = new ArrayList <Point>();
		
		System.out.println("Oto wierzcholki i ich sciezki : ");
		int a = 0;
		int b = 0;
		Graph gr2 = new Graph(1, 1);
		while(done.size() < pointCounter) {
			
			boolean test_points1 = true;
			boolean test_points2 = true;
			
			
			for(Point p1 : gr2.points) {
				if(p1.getNumber() == edges.get(0).getBegin().getNumber()) {
					test_points1 = false;
					break;
				}
			}
			if(test_points1 == true) {
				gr2.add_point(edges.get(0).getBegin(), edges.get(0).getBegin().getValue());
				gr2.a
				a = edges.get(0).getBegin().getNumber();
			}
			
			for(Point p1 : gr2.points) {
				if(p1.getNumber() == edges.get(0).getEnd().getNumber()) {
					test_points2 = false;
					break;
				}
			}
			if(test_points2 == true) {
				gr2.add_point(edges.get(0).getEnd(), edges.get(0).getEnd().getValue());
				b = edges.get(0).getEnd().getNumber();
			}
			System.out.println("jestem");
			
//			this.addEdge(edges.get(0));
			System.out.println(edges.size());
			System.out.println(edges.size());
			
			System.out.println(gr2.points.get(0).getNumber());
	    	gr2.addEdge2(edges.get(0));
	    	System.out.println(gr2.points.get(0).getEdgeList().get(0) + "hehe");
			edges2.add(edges.get(0));
			edges.remove(0);
			if(gr2.isCyclic()) {
				edges2.remove(edges2.size());
				if(test_points1 == true) {
					gr2.removePoint(a);
				}
				if(test_points2 == true) {
					gr2.removePoint(b);
				}
				
			}
			
		}
		
		for(Edge e1 : edges2) {
			System.out.println(e1.toString());
		}
		
		
		
		
		/*
		int test1 = 0, test2 = 0;
		while(done.size() < pointCounter) {
			Edge e10 = new Edge(edges.get(0).getBegin(), edges.get(0).getEnd(), edges.get(0).getWeight());
			test1 = 0;
			test2 = 0;
			for(Point p1 : done) {
				if(p1.getNumber() == e10.getBegin().getNumber())
					test1++;
				if(p1.getNumber() == e10.getEnd().getNumber())
					test2++;
			}
			
			if(test1 == 0 && test2 == 0) {
				done.add(e10.getBegin());
				done.add(e10.getEnd());
			}
			else if(test1 == 1 && test2 == 0) {
				done.add(e10.getEnd());
			}
			else if(test1 == 0 && test2 == 0) {
				done.add(e10.getBegin());
			}
			else {
				
			}
			System.out.println();
			
			edges.remove(0);
		}
	    */
	    
	
	
	//}
	/*
	class subset 
    { 
        int parent, rank; 
    }; */
  
	/*
	public void minimumSpanningTree() {

		
		
		ArrayList <Edge> edges= new ArrayList<Edge>();
		
		for(Point p1 : points) {
			LinkedList<Edge> edges3 = new LinkedList<Edge>();
			edges3 = p1.getEdgeList();
			for(Edge e1 : edges3) {
				edges.add(e1);
			}
		}
		
		ArrayList <Edge> edges2 = new ArrayList<Edge>();
		
		Collections.sort(edges, Edge.EdgeComparator);
		
		
		
		for(Edge e2 : edges) {
			System.out.println(e2.toString());
		}
		
		
        Edge result[] = new Edge[V];  // Tnis will store the resultant MST 
        int e = 0;  // An index variable, used for result[] 
        int i = 0;  // An index variable, used for sorted edges 
        for (i=0; i<V; ++i) 
            result[i] = new Edge(); 
  
        // Step 1:  Sort all the edges in non-decreasing order of their 
        // weight.  If we are not allowed to change the given graph, we 
        // can create a copy of array of edges 
        Collections.sort(edges, Edge.EdgeComparator);
  
        // Allocate memory for creating V ssubsets 
        subset subsets[] = new subset[V]; 
        for(i=0; i<V; ++i) 
            subsets[i]=new subset(); 
  
        // Create V subsets with single elements 
        for (int v = 0; v < V; ++v) 
        { 
            subsets[v].parent = v; 
            subsets[v].rank = 0; 
        } 
  
        i = 0;  // Index used to pick next edge 
  
        // Number of edges to be taken is equal to V-1 
        while (e < V - 1) 
        { 
            // Step 2: Pick the smallest edge. And increment  
            // the index for next iteration 
            Edge next_edge = new Edge(); 
            next_edge = edge[i++]; 
  
            int x = find(subsets, next_edge.src); 
            int y = find(subsets, next_edge.dest); 
  
            // If including this edge does't cause cycle, 
            // include it in result and increment the index  
            // of result for next edge 
            if (x != y) 
            { 
                result[e++] = next_edge; 
                Union(subsets, x, y); 
            } 
            // Else discard the next_edge 
        } 
  
        // print the contents of result[] to display 
        // the built MST 
        System.out.println("Following are the edges in " +  
                                     "the constructed MST"); 
        for (i = 0; i < e; ++i) 
            System.out.println(result[i].src+" -- " +  
                   result[i].dest+" == " + result[i].weight); 
	}
	
	
	public boolean isCyclic() {
		
		
		
		ArrayList <Edge> edges= new ArrayList<Edge>();
		
		for(Point p1 : points) {
			LinkedList<Edge> edges3 = new LinkedList<Edge>();
			edges3 = p1.getEdgeList();
			for(Edge e1 : edges3) {
				edges.add(e1);
			}
		}
		System.out.println("dziala");
		
		
		boolean[] visited = new boolean[this.getPointCounter()]; 
        boolean[] recStack = new boolean[this.getPointCounter()]; 
        
        for (int i = 0; i < this.getPointCounter(); i++) 
            if (isCyclicUtil(i, visited, recStack, edges)) 
                return true; 
  
        return false; 
	}*/
    /*
    public Point findMinim(LinkedList<Edge> edge) {
    	int minim = 10000;
    	Edge e1 = new Edge(new Point(1,1), new Point(1,1), 1);
    	for(Edge e2 : edge) {
    		if(e2.getWeight() < minim) {
    			minim = e2.getWeight();
    			e1.setEnd(e2.getEnd());
    		}
    	}
    	return e1.getEnd();
    }
    
    public void shortestPath(int key) {
    	Graph gr2 = new Graph(1, 1);
    	gr2.add_point(new Point(pointCounter, key));
    	while(gr2.pointCounter < this.pointCounter) {
    		for(Point p1: this.points) {
    			if(p1.getNumber() == key) {		// nie to tylko jezeli juz sie znajduje
    				gr2.add_point(findMinim(p1.getEdgeList()));
    			}
    		
    	}
    }*/
    
    
 //   static final int V = 9; 
    int minDistance(int dist[], Boolean sptSet[]) 
    { 
        // ustawienie na nieskonczonosci 
        int min = Integer.MAX_VALUE, min_index = -1; 
  
        for (int v = 0; v < pointCounter; v++) 
            if (sptSet[v] == false && dist[v] <= min) { 
                min = dist[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
  
    //wypisanie
    void printSolution(int dist[], int n) 
    { 
        System.out.println("Punkt   Odleglosc od poczatku"); 
        for (int i = 0; i < pointCounter; i++) 
            System.out.println(i + " od " + dist[i]); 
    } 
  

    void dijkstra(int graph[][], int src) 
    { 
        int dist[] = new int[pointCounter]; // najkrotsze dynstanse od zrodla do punktu
  

        Boolean sptSet[] = new Boolean[pointCounter]; 
  
        // wszystkie dystance na max
        for (int i = 0; i < pointCounter; i++) { 
            dist[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        } 
  
        // do sourca jest zawsze 0
        dist[src] = 0; 
  
        for (int count = 0; count < pointCounter - 1; count++) { 
            int u = minDistance(dist, sptSet); 
  
            sptSet[u] = true; 
 
            for (int v = 0; v < pointCounter; v++) 
  
                if (!sptSet[v] && graph[u][v] != 0 &&  
                   dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) 
                    dist[v] = dist[u] + graph[u][v]; 
        } 
        
        printSolution(dist, pointCounter); 
    }
	
public boolean isCyclic() {
		
		
		
		ArrayList <Edge> edges= new ArrayList<Edge>();
		
		for(Point p1 : points) {
			LinkedList<Edge> edges3 = new LinkedList<Edge>();
			edges3 = p1.getEdgeList();
			for(Edge e1 : edges3) {
				edges.add(e1);
			}
		}
			// przekopiowujemy do edges wszystkie krawedzi jakie mamy w grafie
		
		
		boolean[] visited = new boolean[this.getPointCounter()]; 
        boolean[] recStack = new boolean[this.getPointCounter()]; 
        
        for (int i = 0; i < this.getPointCounter(); i++) 
            if (isCyclicUtil(i, visited, recStack, edges)) 
                return true; 
  
        return false; 
	}



public void kruskalMST(){
	
	ArrayList <Edge> pq2= new ArrayList<Edge>();
	int counter = 0;
	for(Point p1 : points) {
		LinkedList<Edge> edges3 = new LinkedList<Edge>();
		edges3 = p1.getEdgeList();
		for(Edge e1 : edges3) {
			pq2.add(e1);
			counter++;
		}
	}
	PriorityQueue<Edge> pq = new PriorityQueue<>(counter, Edge.EdgeComparator);
	
	for(Point p1 : points) {
		LinkedList<Edge> edges3 = new LinkedList<Edge>();
		edges3 = p1.getEdgeList();
		for(Edge e1 : edges3) {
			pq.add(e1);
		}
	}

    int [] parent = new int[pointCounter];

    makeSet(parent);

    ArrayList<Edge> mst = new ArrayList<>();

    //process pointCounter - 1 edges
    int index = 0;
    while(index<pointCounter-1){
        Edge edge = pq.remove();
        //sprawdzenie czy dodanie tej krawedzi utworzy cykl
        int x_set = find(parent, edge.getBegin().getNumber());
        int y_set = find(parent, edge.getEnd().getNumber());

        if(x_set==y_set){
            //jezeli tak to nie
        }else {
            //dodajemy do naszych krawedzi w przeciwnych wypadku
            mst.add(edge);
            index++;
            union(parent,x_set,y_set);
        }
    }
    //print MST
    System.out.println("Minimum Spanning Tree: ");
    printGraph(mst);
}

public void makeSet(int [] parent){
	// utworzenie nowego elementu ze wskaznikiem na jego rodzica
    for (int i = 0; i <pointCounter ; i++) {
        parent[i] = i;
    }
}

public int find(int [] parent, int vertex){

	// lancuch rodzicow az do osiagniecia ze rodzic jest soba samym
    if(parent[vertex]!=vertex)
        return find(parent, parent[vertex]);;
    return vertex;
}

public void union(int [] parent, int x, int y){
    int x_set_parent = find(parent, x);
    int y_set_parent = find(parent, y);
    parent[y_set_parent] = x_set_parent;
}

public void printGraph(ArrayList<Edge> edgeList){
    for (int i = 0; i <edgeList.size() ; i++) {
        Edge edge = edgeList.get(i);
        System.out.println("Edge-" + i + " getBegin(): " + edge.getBegin() +
                " getEnd(): " + edge.getEnd() +
                " weight: " + edge.getWeight());
    }
}
    
    
	 public int[][] getGrp() {
	return grp;
}
	 
public void setGrp(int[][] grp) {
	this.grp = grp;
}
	public boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack, ArrayList <Edge> edges)  { 

// oznaczenie obecnego noda jako odwiedzonego i dodanie do stosu
		 

		 if (recStack[i]) 
			 return true; 
		 if (visited[i]) 
			 return false; 
		 visited[i] = true; 

		 recStack[i] = true; 
		 
		 // w tej liscie maja byc te wierzcholki do ktorych jedziemy z tego punktu
		 ArrayList <Integer> children = new ArrayList <Integer>();
		 LinkedList <Edge> edges3 = new LinkedList <Edge>();
		 edges3 = this.getPoint(i).getEdgeList();
		 
		 for(Edge e5 : edges3) {
			 children.add(e5.getEnd().getNumber());
		 }
		
		 for (Integer c: children) 
			 if (isCyclicUtil(c, visited, recStack, edges)) 
				 return true; 

		 recStack[i] = false; 

		 return false; 
	 }
}
