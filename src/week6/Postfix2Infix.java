package week6;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Postfix2Infix {

    public static HashSet<Character> operators = Infix2Postfix.loadOperators();

    public static String postfix2infix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        Scanner scan = new Scanner(postfix);

        String infix = "";
        while (scan.hasNext()) {
            String current_token = scan.next();
            // add number to the stack
            if (operators.contains(current_token)) {
                if (stack.size() >= 2) {
                    stack.push(operator2inputs('+', stack.pop(), stack.pop()));
                }
            }

            System.out.println(current_token);
        }

        scan.close();
        return postfix;
    }

    public static int operator2inputs(char operator, int a, int b) {
        int output = 0;
        switch (operator) {
            case '+' -> output = a + b;
            case '-' -> output = a - b;
            case '*' -> output = a * b;
            case '/' -> output = a / b;
        }
        return output;
    }

    public static void main(String[] args) {
        postfix2infix("123 12");
    }

    // public static HashSet<Character> loadOperators() {
    //     HashSet<Character> hs = new HashSet<>();
    //     hs.add('+');
    //     hs.add('-');
    //     hs.add('*');
    //     hs.add('/');
    //     return hs;
    // }
}
