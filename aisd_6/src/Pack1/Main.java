package Pack1;

import java.util.Scanner;

public class Main {

	        public static void main(String[] args)

	        {

	            Scanner scan = new Scanner(System.in);

	            System.out.println("Binomial Tree Test\n");

	            System.out.println("\nEnter order of binomial tree");

	            /** Creating object of Binomial tree **/

	            BinomialTree bt = new BinomialTree(scan.nextInt());           

	            char ch;

	            /**  Perform tree operations  **/

	            do    

	            {

	                System.out.println("\nBinomial Tree Operations\n");

	                System.out.println("1. insert ");

	                System.out.println("2. size");

	                System.out.println("3. check empty"); 

	                System.out.println("4. clear");

	     

	                int choice = scan.nextInt();            

	                switch (choice)

	                {

	                case 1 : 

	                    System.out.println("Enter integer element to insert");

	                    bt.insert( scan.nextInt() );                     

	                    break;                          

	                case 2 : 

	                    System.out.println("Nodes = "+ bt.getSize());

	                    break;     

	                case 3 :  

	                    System.out.println("Empty status = "+ bt.isEmpty());

	                    break;   

	                case 4 :  

	                    bt.clear();

	                    System.out.println("\nTree Cleared\n");

	                    break;            

	                default : 

	                    System.out.println("Wrong Entry \n ");

	                    break;   

	                }

	                /**  Display tree  **/ 

	                bt.printTree();

	     

	                System.out.println("\nDo you want to continue (Type y or n) \n");

	                ch = scan.next().charAt(0);                        

	            } while (ch == 'Y'|| ch == 'y');               

	        }

	    }
