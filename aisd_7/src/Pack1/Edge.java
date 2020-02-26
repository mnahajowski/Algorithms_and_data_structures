package Pack1;

import java.util.Comparator;
import java.util.Collections;

public class Edge {
	private Point begin, end;	// wierzcholek poczatek i koniec
	private int weight;	// waga krawedzi
	
	public Edge(Point begin, Point end, int weight) {
		this.begin = begin;
		this.end = end;
		this.weight = weight;
	}
	
	public Edge(Point begin, Point end) {
		this.begin = begin;
		this.end = end;
	}

	public String toString() {
		 return Integer.toString( begin.getNumber() ) + " ---( "
	               + Double.toString( weight ) + " )---> "
	               + Integer.toString( end.getNumber() );
		
	}
	public Point getBegin() {
		return begin;
	}

	public void setBegin(Point begin) {
		this.begin = begin;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public static Comparator<Edge> EdgeComparator = new Comparator<Edge>() {
        public int compare(Edge e1, Edge e2)  {
                return e1.getWeight() - e2.getWeight();        
        }
    };
	
}
