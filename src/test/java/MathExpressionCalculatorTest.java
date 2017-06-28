import math.MathExpressionCalculator;
import org.junit.Test;

import static org.junit.Assert.*;

public class MathExpressionCalculatorTest {

    private MathExpressionCalculator calculator = new MathExpressionCalculator();
    private String result;

    @Test
    public void calculateMathExpressionFirstTest() {
        String mathExpression = "8/3+14-2*4+3";
        try {
            result = calculator.calculate(mathExpression);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("11.666666", result);
    }

    @Test
    public void calculateMathExpressionSecondTest() {
        String mathExpression = "9/25+3-5*15";
        try {
            result = calculator.calculate(mathExpression);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("-71.64", result);
    }

    @Test
    public void calculateMathExpressionThirdTest() {
        String mathExpression = "35/3+4*5-2";
        try {
            result = calculator.calculate(mathExpression);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("29.666668", result);
    }

    @Test
    public void calculateMathExpressionFourIfFirstNumberNegativeTest() {
        String mathExpression = "-8/3+14-2*4+3";
        try {
            result = calculator.calculate(mathExpression);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("6.333333", result);
    }

    @Test
    public void sameResultOfCalculatingIfMathExpressionHasOnlyOneNumber() {
        String mathExpression = "3";
        try {
            result = calculator.calculate(mathExpression);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("3", result);
    }

    @Test(expected = Exception.class)
    public void exceptionExpectedIfInputExpressionContainsFloatNumbersTest() throws Exception {
        String mathExpression = "2.3+3*2/5";
        result = calculator.calculate(mathExpression);
    }

    @Test(expected = Exception.class)
    public void exceptionExpectedIfInputExpressionContainsLetters() throws Exception {
        String mathExpression = "2.3+3*2/5ab";
        result = calculator.calculate(mathExpression);
    }

}
