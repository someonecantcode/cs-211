package week4;

import java.util.HashMap;
import java.util.Stack;

public class Expression_Evaluation {

    public static HashMap<Character, Character> pair = loadPair();
    public static HashMap<Character, String> errorMessage = loadErrorMessage();

    public static boolean expression_evaluation(String statement) {


        Stack<Character> stack = new Stack<>();
        boolean valid = true;

        stack.push(' ');
        System.out.println(statement);
        for (int j = 0; j < statement.length(); j++) {
            char c = statement.charAt(j);
            if ((c == '{') || (c == '(')) {
                stack.push(c);
            }
            if ((c == ')') || (c == '}')) {
                char popChar = stack.pop();
                if (pair.get(c) != popChar) {
                    printError(popChar, j);
                    return false;
                }
            }
        } // end for

        if(stack.size() != 1){
            printError(stack.peek(), statement.length());
            valid = false;
        }
        return valid;
    }

    public static void printError(char statement, int location) {
        System.out.println(" ".repeat(location) + errorMessage.get(statement));
    }

    public static  HashMap<Character, String> loadErrorMessage() {
        HashMap<Character, String> errorMessage = new HashMap<>();
        errorMessage.put(' ', "^ Incomplete Expression");
        errorMessage.put('{', "^ " + pair.get('{') + " expected");
        errorMessage.put('(', "^ " + pair.get('(') + " expected");
        return errorMessage;
    }

    public static HashMap<Character, Character>  loadPair() {
        HashMap<Character, Character> pair = new HashMap<>();
        pair.put(')', '(');
        pair.put('}', '{');

        // closing pairs
        pair.put('(', ')');
        pair.put('{', '}');
        return pair;
    }

}