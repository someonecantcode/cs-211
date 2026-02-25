package week7;
import java.util.ArrayList;

//Winter 2026

public class Heap211 {

    static public ArrayList <Integer> heap = new ArrayList<>();
    
    
    Heap211() {
    	heap.add(0);  // must understan why we need add(0)
    }

   
   
    /* project 3
          
    int parent(int index) {
        return . . .;
    }

    
    int leftChild(int index) {
        return . . .;
    }

    
    int rightChild(int index) {
        return . . .;
    }

    
    boolean hasParent(int index) {
        return . . .;
    }

    
    boolean hasLeftChild(int index) {
        return . . .;
    }

    
    boolean hasRightChild(int index) {
        return . . .;
    }
        
    
    void swap(int a, int b) {
        int temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b,temp);
    }

    */
    
    

/////////////////////////////////////////////////

    // CP 16: MISSON 1 

    
    int peekMin() {
        return heap.get(1);
    }
    
    // end of MISSON 1 

//////////////////////////////////////




    
    boolean isEmpty() {
        return heap.size() == 1;
    }

    
    
    void add(int value) {

    	
/////////////////////////////////////////

    	// CP 16: MISSON 2 

    	
         heap.add(value); // add as rightmost leaf
        
        // end of MISSON 2 

////////////////////////////////////////



       	System.out.println("   heap: " +printHeap());
       	System.out.println("   bubble-up: start");


           	
       	// project 3
       	/*
           implement bubbling-up here
           
        */
       	
        System.out.println("   bubble-up: end");
    	System.out.println("   new heap: " +printHeap());
    }

     
    
    int remove() {  
    	
    	System.out.println("   heap: " +printHeap());  
       


/////////////////////////////////////

    	// CP 16: MISSON 3  

    	
    	int min = peekMin();  // peek min value by calling peekMin()
        heap.set(1, heap.get(heap.size()-1)); // move the last node to the first. tip: use one of the ArrayList methods
        System.out.println("   Removed: " + min);
        heap.remove(heap.size()-1); // delete the last node from the heap. The heap is reduced.
        
    	 // end of MISSON 3 

////////////////////////////////////////



       	System.out.println("   heap: " +printHeap());   
     	System.out.println("   bubble-down: start");
     	

        // project 3
     	/*
         implement bubbling-down here

        */
     	
        System.out.println("   bubble-down: end");
    	System.out.println("   new heap: " +printHeap());
    	
      
       return min;
    }
    

    //use this method as is (DO NOT CHANGE)
    public String printHeap(){
    	
        StringBuilder result = new StringBuilder("["); 
        
        if (heap.size()>1) {
         result.append(heap.get(1));
        }
        
        for (int i = 2; i < heap.size(); i++){
            result.append(", ").append(heap.get(i));
        }
                     
        return result + "]";
    }
    
}
