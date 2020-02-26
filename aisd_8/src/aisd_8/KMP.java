package aisd_8;

public class KMP {
	    void KMPSearch(String pat, String txt) { 
	    	double start, end;
	        int M = pat.length(); 	// dlugosc naszego wzorca
	        int N = txt.length(); 	// dlugosc tekstu ktory sprawdzamy
	  

	        int lps[] = new int[M]; 
	        int j = 0;

	        LPS(pat, M, lps); 
	        start = System.nanoTime();
	  
	        int i = 0; 
	        while (i < N) { 
	            if (pat.charAt(j) == txt.charAt(i)) { 
	                j++; 
	                i++; 
	            } 
	            if (j == M) { 
	            	end = System.nanoTime();
	                System.out.println("Znaleziono na indeksie  " + (i - j) + " czas : " + (end - start)); 
	                j = lps[j - 1]; 
	            } 
	            else if (i < N && pat.charAt(j) != txt.charAt(i)) { 

	            	// do 0 zmniejszamy dzialajcy sufiks
	                if (j != 0) 
	                    j = lps[j - 1]; 
	                // jak juz mamy 0 to po prostu przechodzimy na kolejny znak
	                else
	                    i = i + 1; 
	            } 
	        } 
	    } 
	    
	    void LPS(String pat, int M, int lps[]) { 
	       
	        int len = 0; 
	        int i = 1; 
	        lps[0] = 0; // na poczatek 0
	  	   
	        // na calej dlugosci wzorca
	        while (i < M) { 
	            if (pat.charAt(i) == pat.charAt(len)) { 
	                len++; 
	                lps[i] = len; 
	                i++; 
	            } 
	            else { 	                
	                if (len != 0) { 
	                    len = lps[len - 1];                      
	                } 
	                else { 
	                    lps[i] = len; 
	                    i++; 
	                } 
	            } 
	        } 
	    }   
	} 
