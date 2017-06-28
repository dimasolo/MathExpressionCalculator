package math;


public class MathExpressionCalculator {

    private String calculateSimplifiedExpression(String mathExpression) {

        char[] mathExpressionChars = mathExpression.toCharArray();
        StringBuilder firstOperand = new StringBuilder();
        StringBuilder secondOperand;
        for (int i = 0; i < mathExpressionChars.length; i++) {
            char mathExpressionChar = mathExpressionChars[i];

            if (Character.isDigit(mathExpressionChar) || Character.toString(mathExpressionChar).equals(".")
                    || Character.toString(mathExpressionChars[0]).equals("-")
                    && !Character.toString(mathExpressionChar).equals("+") && !firstOperand.toString().contains("-")) {
                firstOperand.append(mathExpressionChar);
                continue;
            }
            switch (mathExpressionChar) {
                case '+': {
                    secondOperand = calculateSecondOperand(i, mathExpressionChars);
                    String result = add(firstOperand.toString(), secondOperand.toString());
                    mathExpression = mathExpression.replace(firstOperand.toString() + "+" + secondOperand.toString(), result);
                    mathExpressionChars = mathExpression.toCharArray();
                    i = getNewIndexAndResetFirstOperand(result, firstOperand);
                    break;
                }
                case '-': {
                    secondOperand = calculateSecondOperand(i, mathExpressionChars);
                    String result = substract(firstOperand.toString(), secondOperand.toString());
                    mathExpression = mathExpression.replace(firstOperand.toString() + "-" + secondOperand.toString(), result);
                    mathExpressionChars = mathExpression.toCharArray();
                    i = getNewIndexAndResetFirstOperand(result, firstOperand);
                    break;
                }
            }

        }

        return mathExpression;
    }

    public String calculate(String mathExpression) throws Exception {

        if (mathExpression.startsWith("+")) {
            mathExpression = mathExpression.substring(1);
        } else if (mathExpression.contains(".") || mathExpression.contains(",")) {
            throw new Exception("Mathematical Expression must contain only integer numbers!");
        }
        char[] mathExpressionChars = mathExpression.toCharArray();
        StringBuilder firstOperand = new StringBuilder();
        StringBuilder secondOperand;
        for (int i = 0; i < mathExpressionChars.length; i++) {

            char mathExpressionChar = mathExpressionChars[i];
            if (Character.isDigit(mathExpressionChar) || Character.toString(mathExpressionChar).equals(".")
                    && !Character.toString(mathExpressionChar).equals("+") && !firstOperand.toString().contains("-")) {
                firstOperand.append(mathExpressionChar);
            } else if (Character.isLetter(mathExpressionChar)) {
                throw new Exception("Mathematical Expression must not contain letters");
            } else {
                switch (mathExpressionChar) {
                    case '+': {
                        firstOperand.setLength(0);
                        break;
                    }
                    case '-': {
                        firstOperand.setLength(0);
                        break;
                    }
                    case '*': {
                        secondOperand = calculateSecondOperand(i, mathExpressionChars);
                        String result = multiply(firstOperand.toString(), secondOperand.toString());
                        mathExpression = mathExpression.replace(firstOperand.toString() + "*" + secondOperand.toString(), result);
                        mathExpressionChars = mathExpression.toCharArray();
                        i = getNewIndexAndResetFirstOperand(result, firstOperand);
                        break;
                    }
                    case '/': {
                        secondOperand = calculateSecondOperand(i, mathExpressionChars);
                        String result = divide(firstOperand.toString(), secondOperand.toString());
                        mathExpression = mathExpression.replace(firstOperand.toString() + "/" + secondOperand.toString(), result);
                        mathExpressionChars = mathExpression.toCharArray();
                        i = getNewIndexAndResetFirstOperand(result, firstOperand);
                        break;
                    }
                }
            }
        }

        return calculateSimplifiedExpression(mathExpression);
    }

    private int getNewIndexAndResetFirstOperand(String result, StringBuilder firstOperand) {
        int index;
        if (result.contains("-")) {
            index = 0;
            firstOperand.setLength(0);
            firstOperand.append("-");
        } else {
            index = -1;
            firstOperand.setLength(0);
        }
        return index;
    }


    private StringBuilder calculateSecondOperand(int index, char[] mathExpressionChars) {
        StringBuilder secondOperand = new StringBuilder();
        for (int j = index + 1; j < mathExpressionChars.length; j++) {
            char mathExpressionChar = mathExpressionChars[j];
            if (Character.isDigit(mathExpressionChar) || Character.toString(mathExpressionChar).equals(".")) {
                secondOperand.append(mathExpressionChar);
            } else {
                break;
            }
        }
        return secondOperand;
    }

    private String divide(String firstOperand, String secondOperand) {
        float result = Float.valueOf(firstOperand) / Float.valueOf(secondOperand);
        return String.valueOf(result);
    }

    private String multiply(String firstOperand, String secondOperand) {
        float result = Float.valueOf(firstOperand) * Float.valueOf(secondOperand);
        return String.valueOf(result);
    }

    private String add(String firstOperand, String secondOperand) {
        float result = Float.valueOf(firstOperand) + Float.valueOf(secondOperand);
        return String.valueOf(result);
    }

    private String substract(String firstOperand, String secondOperand) {
        float result = Float.valueOf(firstOperand) - Float.valueOf(secondOperand);
        return String.valueOf(result);
    }
}
