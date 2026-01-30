package week4;

import java.util.Scanner;

public class CP5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Boolean valid;
        String mathExpression;

        while (true) {
            System.out.printf("\nEnter a math expression: ");
            mathExpression = "";
            mathExpression = input.nextLine();
            if (mathExpression.length() == 0) {
                System.out.printf("\nBye!");
                break;
            } else {
                valid = Expression_Evaluation.expression_evaluation(mathExpression);
                if (valid) {
                    System.out.println("Valid");
                } // end if (valid)
            } // end else
        } // end while
        input.close();
    }

}
