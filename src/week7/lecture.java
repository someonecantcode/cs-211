package week7;

import java.util.PriorityQueue;
import java.util.Stack;

public class lecture {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(5);
        pq.add(8);
        pq.add(3);
        pq.add(7);

        System.out.println(pq.remove());
        System.out.println(pq);

        Stack<String> myStake = new Stack<>();
        myStake.push("A");
        myStake.push("B");
        myStake.push("C");
        System.out.println(myStake.search("A"));
    }
}



    
         