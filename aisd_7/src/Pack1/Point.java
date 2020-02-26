package Pack1;
import java.text.ParsePosition;
import java.util.LinkedList;

public class Point {
	private int number;		// id wierzcholka
	private LinkedList<Edge> edge = new LinkedList<Edge>();
	private int value;
	
	public Point(int number, int value) {
		this.number = number;
		this.value = value;
	}
	
	public Point(Point p1) {
		this.number = p1.getNumber();
		this.edge = p1.getEdge();
		this.value = p1.getValue();
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String toString()
    {/*
        if(edge.size() == 0)
            return "";
 
        String out = new String();
        for(Edge e : edge)
            out = out + e.toString() + "\n";
        return out;*/
		return Integer.toString(this.getNumber()) + " ";
        
    }
	
	public LinkedList<Edge> getEdgeList()
    {
        return new LinkedList<Edge>(edge);
    }
	// usuwa wszystkie krawedzie biegnace do wierzcholka index
	public void removeEdge(int index) {
		
		for(int i = 0; i <= edge.size(); i++) {
			if(edge.get(i).getEnd().getNumber() == index)
				edge.remove(i);
				
		}
	}
	
	public void removeEdge(Point p) {
		removeEdge(p.getNumber());
	}
	
	public void addEdge(Edge e) {
		edge.add(e);
	}
	
	// zwraca krawedz biegnaca do wierzcholka o id n
	public Edge getEdge(int n) {
		for(Edge e : edge) {
			if(e.getEnd().getNumber() == n)
				return e;
		}
		return null;
	}
	
	public void showEdges() {
		for(Edge e : edge) {
//			System.out.println(e.getBegin() + " " + e.getEnd() + " " + e.getWeight());
			System.out.println(e.toString());
		}
	}
	
	public void showSiblings() {
		for(Edge e : edge) {
			System.out.print(e.getEnd().toString());
		}
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public LinkedList<Edge> getEdge() {
		return edge;
	}

	public void setEdge(LinkedList<Edge> edge) {
		this.edge = edge;
	}
	
	public void degreeOutput() {
		System.out.println("Wychodzi z niego tyle sciezek : " + edge.size());
	}
	
	public int degreeInput(Point p1) {
		int counter = 0;
		for(Edge e : edge) {
			if(e.getEnd().getNumber() == p1.getNumber())
				counter++;
		}
		return counter;
	}
	
	public void checkSiblings(Point p1)  {
		for(Edge e : edge) {
			if(e.getEnd().getNumber() == p1.getNumber())
				System.out.print(e.getBegin().toString());
		}
	
	}
	
}
