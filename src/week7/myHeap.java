package week7;
import java.util.Random;

// Winter 2026

public class myHeap {

	   final static int HOW_MANY_TESTs = 5;
	   
	   public static void main(String[] args) {
		   
		   System.out.println("Project 3. MinHeap (Winter 2026)");
		   		   
	        Random random = new Random();
	        Heap211 minHeap = new Heap211();	 	        
	        
	        for (int test = 1; test <= HOW_MANY_TESTs; test++) {
	        	
	        	System.out.println();        	
	             int whatAction = random.nextInt(3); 
				// int whatAction = 1;
	            
	            if (whatAction <= 1) { //add
	            	
	                // generate a node (random number) to add.
	                int node = random.nextInt(50); // 0~49
	              	                
	  	            System.out.println("Action " + test + ": Add " + node);
	             
	                // add node to the heap	                
	                minHeap.add(node);	                  
	            } 
	            
	            else if (whatAction == 2) { //remove
	                if (minHeap.isEmpty()) {
	                    //skip this action, do not count this action
	                    test = test - 1;	                    
	                } else {	                	
	   		             System.out.println("Action " + test+": Remove min");	   		             
	                     minHeap.remove();		                     
	                }
	            }
	        }
	    }
	}