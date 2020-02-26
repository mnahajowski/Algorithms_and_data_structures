package Pack1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc1 = new Scanner(System.in);
		int choice, choice2;
		
		System.out.println("Witamy w kreatorze grafow\nJaki graf chcesz utworzyc?\n1. Skierowany\n2. Nieskierowany");
		choice = sc1.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("1. Ważony\n2. Nieważony");
			choice2 = sc1.nextInt();
			switch(choice2) {
			case 1:
				System.out.println("Utworzyles graf skierowany wazony");
				break;
			case 2:
				System.out.println("Utworzyles graf skierowany niewazony");			
				break;
			default:
				choice2 = 1;
				System.out.println("Utworzyles graf skierowany wazony");				
				break;
			}
			break;
		case 2:
			System.out.println("1. Ważony\n2. Nieważony");
			choice2 = sc1.nextInt();
			switch(choice2) {
			case 1:
				System.out.println("Utworzyles graf nieskierowany wazony");				
				break;
			case 2:
				System.out.println("Utworzyles graf nieskierowany niewazony");				
				break;
			default:
				choice2 = 1;
				System.out.println("Utworzyles graf nieskierowany wazony");				
				break;
			}
			break;

		default :
			choice = 1;
			choice2 = 1;			
			break;
		}
		
		Graph gr1 = new Graph(choice, choice2);
		
//		int choice3;
//		boolean test = true;
		//ILE DODAC WIERZCHOLKOW
		
		gr1.tworzenie(9);
		gr1.addEdge(7, 6, 1);
		gr1.addEdge(8, 2, 2);
		gr1.addEdge(6, 5, 2);
		gr1.addEdge(0, 1, 4);
		gr1.addEdge(2, 5, 4);
		gr1.addEdge(8, 6, 6);
		gr1.addEdge(2, 3, 7);
		gr1.addEdge(7, 8, 7);
		gr1.addEdge(0, 7, 8);
		gr1.addEdge(1, 2, 8);
		gr1.addEdge(3, 4, 9);
		gr1.addEdge(5, 4, 10);
		gr1.addEdge(1, 7, 11);
		gr1.addEdge(3, 5, 14);
		gr1.degreeOutput(1);
		gr1.degreeInput(1);
		
		gr1.showSiblings(1);
		gr1.showSiblings(2);
		gr1.toTablica();
		gr1.dijkstra(gr1.getGrp(), 0);
		
		gr1.kruskalMST();
//		gr1.minimumSpanningTree();
		
		gr1.showEdges();
		
		/*
		gr1.add_point();	//1
		gr1.add_point();	//2
		gr1.add_point();	//3
		gr1.add_point();	//4
		gr1.add_point();	//5
		gr1.add_point();	//6
		gr1.add_point();	//7
		gr1.add_point();	//8
		
		System.out.println(gr1.getPointCounter());
		
		gr1.showPoints();
		gr1.degreeOutput(1);
		gr1.degreeInput(1);
		
		gr1.showSiblings(1);
		gr1.showSiblings(2);*/
		
		/*
		gr1.tworzenie(4);
		gr1.addEdge(0, 1, 1);
		gr1.addEdge(0, 2, 2);
		gr1.addEdge(1, 2, 2);
		gr1.addEdge(2, 0, 4);
		gr1.addEdge(2, 3, 4);
		gr1.addEdge(3, 3, 6);
		
		
		gr1.addEdge(0,1,1);
		gr1.addEdge(0,2,1);
		gr1.addEdge(1,2,1);

		
		
		 if(gr1.isCyclic()) 
	            System.out.println("Graf zawiera cykl"); 
	        else
	            System.out.println("Graf nie zawiera cyklu"); 
		
		*/
		
		
		/*
		
		do {
			System.out.println("Co chcesz zrobic?");
			
			choice3 = sc1.nextInt();
			switch(choice3) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 5:
				test = false;
				break;
			default:
				break;
			}
			
			
			
			
			
		}while(test == true);*/
	}

}
