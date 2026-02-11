package week6;

import java.util.Scanner;

public class myExpression {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String infixInput;
        while (true) {
            System.out.print("Enter a math expression: ");
            infixInput = scan.nextLine();

            if (infixInput.length() == 0) {
                break;
            }

            System.out.printf("infix: %s %n", infixInput);
            String postfix = Infix2Postfix.infix2postfix(infixInput);

            System.out.printf("postfix: %s %n", postfix);
            System.out.printf("result: %d %n%n", postfixEvaluation.postfixevaluation(postfix));
        }

        System.out.println("Bye!");
        scan.close();
    }
}
