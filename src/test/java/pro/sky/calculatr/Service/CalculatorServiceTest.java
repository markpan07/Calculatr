package pro.sky.calculatr.Service;

import org.junit.jupiter.api.Test;
import pro.sky.calculatr.Exception.BadRequiredParamException;
import pro.sky.calculatr.Exception.DivideByZeroException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorServiceTest {
    private double a = 5;
    private double b = 7;
    private double c = 7.7;
    private double d = 3.8;
    private double zero = 0;
    CalculatorService s = new CalculatorService();

    @Test
    public void minusTest() {
        CalculatorService s = new CalculatorService();
        double expected = s.minus(a, b);
        double fact = a - b;
        assertEquals(expected, fact);
        double expected2 = s.minus(c, d);
        double fact2 = c - d;
        assertEquals(expected2, fact2);
    }

    @Test
    public void plusTest() {
        double expected = s.plus(a, b);
        double fact = a + b;
        assertEquals(expected, fact);
        double expected2 = s.plus(c, d);
        double fact2 = c + d;
        assertEquals(expected2, fact2);
    }

    @Test
    public void multiplyTest() {
        double expected = s.multiply(a, b);
        double fact = a * b;
        assertEquals(expected, fact);
        double expected2 = s.multiply(c, d);
        double fact2 = c * d;
        assertEquals(expected2, fact2);
    }

    @Test
    public void divideTest() {
        double expected = s.divide(a, b);
        double fact = a / b;
        assertEquals(expected, fact);
        double expected2 = s.divide(c, d);
        double fact2 = c / d;
        assertEquals(expected2, fact2);
    }

    @Test
    public void divideByZeroTest() {
        assertThrows(DivideByZeroException.class, () -> {
            s.divide(a, zero);
        });
    }

    @Test
    public void answerBuildPlusTest() {
        String expected = a + " " + "+" + " " + b + " = " + s.plus(a, b);
        String fact = s.answerBuild(a, b, "+");
        assertEquals(expected, fact);
    }

    @Test
    public void answerBuildMinusTest() {
        String expected = a + " " + "-" + " " + b + " = " + s.minus(a, b);
        String fact = s.answerBuild(a, b, "-");
        assertEquals(expected, fact);
    }

    @Test
    public void answerBuildMultiplyTest() {
        String expected = a + " " + "*" + " " + b + " = " + s.multiply(a, b);
        String fact = s.answerBuild(a, b, "*");
        assertEquals(expected, fact);
    }

    @Test
    public void answerBuildDivideTest() {
        String expected = a + " " + "/" + " " + b + " = " + s.divide(a, b);
        String fact = s.answerBuild(a, b, "/");
        assertEquals(expected, fact);
    }


    @Test
    public void absenseOneOfParamTest() {
        assertThrows(BadRequiredParamException.class, () -> {
            s.answerBuild(a, null, "/");
        });
    }

    @Test
    public void absenseBothOfParamTest() {
        assertThrows(BadRequiredParamException.class, () -> {
            s.answerBuild(null, null, "/");
        });
    }

}
