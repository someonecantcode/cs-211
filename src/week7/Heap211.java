package week7;

import java.util.ArrayList;

/**
 * Winter 2026
 *
 * These are all of the methods for the minHeap. It handles all of the adding
 * and removing methods alongside its helper functions and initilization.
 *
 * @author Brendan Tea
 * @date 2026-02-25 
 * 
 */
public class Heap211 {

    // shouldn't be static as you may want multiple instances of heaps.
    public ArrayList<Integer> heap = new ArrayList<>();

    Heap211() {
        heap.add(0);  // must understan why we need add(0)
    }

    // project 3
    // parent, left/right child are just pattern formulas given.
    int parent(int index) {
        return index / 2;
    }

    int leftChild(int index) {
        return index * 2;
    }

    int rightChild(int index) {
        return leftChild(index) + 1;
    }

    // this is redudant due to isEmpty() method
    // boolean hasParent(int index) { // literally checking if root exists
    //     // 0 root leftroot rightroot
    //     // 0  1      2       3
    //     return index > 1;
    // }
    // checking if indices are in range
    boolean hasLeftChild(int index) {
        return leftChild(index) < heap.size();
    }

    boolean hasRightChild(int index) {
        return rightChild(index) < heap.size();
    }

    void swap(int a, int b) {
        int aValue = heap.get(a);
        int bValue = heap.get(b);

        heap.set(a, bValue);
        heap.set(b, aValue);

        System.out.printf("%10s %d<->%d %n", "swap", aValue, bValue);
    }

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

       	System.out.println("   heap: " + printHeap());
        System.out.println("   bubble-up: start");

        // project 3 implement bubbling-up here
        bubbleUp(value);

        System.out.println("   bubble-up: end");
        System.out.println("   new heap: " + printHeap());
    }

    int remove() { // assume size >= 1;
        System.out.println("   heap: " + printHeap());

        /////////////////////////////////////

    	// CP 16: MISSON 3  

    	int min = peekMin();  // peek min value by calling peekMin()
        int lastelement = heap.get(heap.size() - 1);

        heap.set(1, lastelement); // move the last node to the first. tip: use one of the ArrayList methods
        System.out.println("   Removed: " + min);
        heap.remove(heap.size() - 1); // delete the last node from the heap. The heap is reduced.
        System.out.print(isEmpty() ? "" : "      last Node(" + lastelement + ") is moved to the root \n");

        // end of MISSON 3 
        ////////////////////////////////////////

       	System.out.println("   heap: " + printHeap());
        System.out.println("   bubble-down: start");

        // project 3 implement bubbling-down here
        bubbleDown();
        //
        System.out.println("   bubble-down: end");
        System.out.println("   new heap: " + printHeap());

        return min;
    }

    void bubbleUp(int value) {
        if (isEmpty()) {
            return;
        }

        int addedValueIndex = heap.size() - 1;
        while (value < heap.get(parent(addedValueIndex))) {
            swap(addedValueIndex, parent(addedValueIndex));
            addedValueIndex = parent(addedValueIndex);
        }
    }

    void bubbleDown() {
        if (isEmpty()) {
            return;
        }

        int removedValueIndex = 1;
        while (heap.get(removedValueIndex) > heap.get(getMinChildIndex(removedValueIndex))) {
            int swapIndex = getMinChildIndex(removedValueIndex);

            swap(removedValueIndex, swapIndex);
            removedValueIndex = swapIndex;
        }
    }

    int getMinChildIndex(int index) {
        // edgecase. check if there exists even 1 child (left).
        if (!hasLeftChild(index)) {
            return index;
        }
        // now we know there exists 100% a left child
        // assume its left. -> only swap to right if there exists right and right is greater.

        int minChild = leftChild(index);
        if (hasRightChild(index) && (heap.get(rightChild(index)) < heap.get(minChild))) {
            return rightChild(index);
        }
        return minChild;
    }

    //use this method as is (DO NOT CHANGE)
    public String printHeap() {

        StringBuilder result = new StringBuilder("[");

        if (heap.size() > 1) {
            result.append(heap.get(1));
        }

        for (int i = 2; i < heap.size(); i++) {
            result.append(", ").append(heap.get(i));
        }

        return result + "]";
    }

}
