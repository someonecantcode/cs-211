package week6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Infix2Postfix {

    public static HashMap<Character, Integer> precedence = loadPrecedence();
    public static HashMap<Character, Character> pair = loadPair();
    public static HashSet<Character> operators = loadOperators();

    public static final String infix2postfix(String infix) {
        Stack<Character> stack = new Stack<>();
        String postfix = "";

        for (int j = 0; j < infix.length(); j++) {
            char c = infix.charAt(j);
            if (Character.isDigit(c)) {
                postfix += c;
                if (j + 1 >= infix.length() || !Character.isDigit(infix.charAt(j + 1))) {
                    postfix += " ";
                }
            }

            if (c == '(' || c == '{') {
                stack.push(c);
            }

            if (c == ')' || c == '}') {
                while (stack.peek() != pair.get(c)) {
                    postfix += stack.pop();
                    postfix += " ";
                }
                stack.pop(); // remove ( {
            }

            if (operators.contains(c)) {
                while (!stack.isEmpty() && (precedence.get(stack.peek())) >= (precedence.get(c))) {
                    postfix += stack.pop();
                    postfix += " ";
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix += stack.pop();
            postfix += " ";
        }

        return postfix;
    }

    public static final HashMap<Character, Integer> loadPrecedence() {
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('(', 0);
        hm.put('{', 0);
        hm.put('+', 1);
        hm.put('-', 1);
        hm.put('*', 2);
        hm.put('/', 2);

        return hm;
    }

    public static HashMap<Character, Character> loadPair() {
        HashMap<Character, Character> pair = new HashMap<>();
        pair.put(')', '(');
        pair.put('}', '{');

        // closing pairs
        pair.put('(', ')');
        pair.put('{', '}');
        return pair;
    }

    public static HashSet<Character> loadOperators() {
        HashSet<Character> hs = new HashSet<>();
        hs.add('+');
        hs.add('-');
        hs.add('*');
        hs.add('/');

        return hs;
    }
}
