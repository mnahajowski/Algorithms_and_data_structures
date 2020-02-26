package aisd_8;

import java.io.*;

public class Main {
	
	String cat(String a, String b) {
        a += b;
        return a;
    }

	  public static void main(String args[]) 
	    { 
		   File plik = null;
			FileReader freader = null;
			BufferedReader breader = null;
			String wiersz_tekstu = null;

			
			String  litery = "";
			
			try {			
				plik = new File("Rok_1984.txt");				
				freader = new FileReader(plik);
				
				breader = new BufferedReader(freader);
				while( (wiersz_tekstu = breader.readLine() ) != null ) {
					litery = litery.concat(wiersz_tekstu);
				}
				new KMP().KMPSearch("Był", litery);
			} catch (Exception e) {
				e.printStackTrace();
			}
		  
		  
	        String txt = "ABABDABACDABABCABAB"; 
	        String txt2 = "AAAAABAAABA";
	        String pat2 = "AAAA";
	        String pat = "ABABCABAB"; 
	        new KMP().KMPSearch(pat, txt); 
	        new KMP().KMPSearch(pat2, txt2); 
	    } 
}
