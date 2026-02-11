package week6;

import java.util.Scanner;
import java.util.Stack;

public class postfixEvaluation {

    public static int postfixevaluation(String postfix) {
        Stack<Integer> stack = new Stack<>();
        Scanner scan = new Scanner(postfix);

        while (scan.hasNext()) {

            // add number to the stack
            if (scan.hasNextInt()) {
                stack.push(scan.nextInt());
            } else {
                // when operator
                if (stack.size() >= 2) {
                    stack.push(operator2inputs(scan.next(), stack.pop(), stack.pop()));
                } else {
                    System.out.println("stack less than 2");
                }
            }
        }

        scan.close();
        return stack.peek();
    }

    public static int operator2inputs(String operator, int a, int b) {
        int output = 0;
        // x1 x2 + in the stack is popped out as x2 x1. we must reverse
        switch (operator) {
            case "+" ->
                output = b + a;
            case "-" ->
                output = b - a;
            case "*" ->
                output = b * a;
            case "/" ->
                output = b / a;
        }
        return output;
    }

}
