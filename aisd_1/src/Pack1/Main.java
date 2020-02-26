package Pack1;

import java.util.Random;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer [] data = new Integer[10];/*
		Random gen = new Random();
		for(int i = 0; i < data.length-1; i++) {
			data[i] = gen.nextInt(20); 
		}*/
		data[0] = 1;
		data[1] = 2;
		data[2] = 3;
		data[3] = 4;
		data[4] = 5;
		data[5] = 6;
		data[6] = 7;
		data[7] = 8;
		data[8] = 9;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		MyList<Integer> m1 = new MyList<Integer>(data, 10);
		m1.show();
		System.out.println("\nRozmiar tablicy " + m1.size());
		m1.add(1111);
		m1.add(111111);
		System.out.println("\nPo dodaniu dwoch liczb");
		m1.show();
		System.out.println("\nRozmiar tablicy " + m1.size());
		System.out.println("\nCzy zawiera liczbe 2 " + m1.contains(2));
		m1.set(5, 1);
		System.out.println("\nZmiana wartosci na konkretnym indeksie");
		m1.show();
		System.out.println("\nSprawdzenie czy lista jest pusta "+ m1.isEmpty());
/*		m1.set(5, 1);
		m1.show();*/
		m1.remove(2);
		System.out.println("\nUsuniecie wartosci z konkretnego indeksu");
		m1.show();
		System.out.println("\nZwrocenie w ktorym indeksie znajduje sie liczba 9, ten indeks to " + m1.indexOf(9));
		m1.clear();
		System.out.println("\nSprawdzenie czy lista jest pusta " + m1.isEmpty());
		
	}
}