package week7;

import java.util.Random;

/**
 * Winter 2026
 *
 * This is the main class that tests our Heap211 program by adding and removing
 * nodes and outputting their responses.
 *
 * @author Brendan Tea
 * @date 2026-02-25 
 * 
 */
public class myHeap {

    final static int HOW_MANY_TESTS = 20;
    final static int RNG = 3; // higher more likely to add

    public static void main(String[] args) {

        System.out.println("Project 3. MinHeap (Winter 2026) \n");

        Random random = new Random();
        Heap211 minHeap = new Heap211();

        for (int test = 1; test <= HOW_MANY_TESTS; test++) {
            int whatAction = random.nextInt(RNG + 1); // 0~RNG

            if (whatAction <= RNG - 1) { //add
                int node = random.nextInt(50); // 0~49
                System.out.println("Action " + test + ": Add " + node);

                minHeap.add(node);
            } else if (whatAction == RNG) { //remove
                if (!minHeap.isEmpty()) {
                    System.out.println("Action " + test + ": Remove min");
                    minHeap.remove();
                } else {
                    test--;
                    continue; // We don't need to print out a line if we're doing nothing.
                }
            }
            System.out.println();
        }

    }

}
