package start;

import math.MathExpressionCalculator;

import java.util.Scanner;

public class Start {

    public static void main(String[] args) {

        String expression;
        MathExpressionCalculator calculator = new MathExpressionCalculator();
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("To exit from program type \'exit\' or \'q\'");
                System.out.print("Please, enter mathematical expression (e.g. 8/3+14-2*4+3): -->> ");
                expression = scanner.nextLine().replaceAll("\\s+", "");

                if (expression.equals("q") || expression.equals("exit")) {
                    System.out.println("Exit!");
                    break;
                }

                String result;
                try {
                    result = calculator.calculate(expression);
                } catch (Exception e) {
                    result = e.getMessage();
                }
                System.out.println("Result: " + result);
            }
            scanner.close();
        } else {
            expression = args[0];
            String result;
            try {
                result = calculator.calculate(expression);
            } catch (Exception e) {
                result = e.getMessage();
            }
            System.out.println("Result: " + result);
        }
    }
}

