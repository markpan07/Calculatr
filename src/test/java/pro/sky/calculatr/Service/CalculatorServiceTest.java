package pro.sky.calculatr.Service;

import org.junit.jupiter.api.Test;
import pro.sky.calculatr.Exception.BadRequiredParamException;
import pro.sky.calculatr.Exception.DivideByZeroException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pro.sky.calculatr.Constants.CalculatorServiceTestConstants.*;


public class CalculatorServiceTest {
    CalculatorService out = new CalculatorService();

    @Test
    public void minusTest() {
        double expected = out.minus(a, b);
        double fact = a - b;
        assertEquals(expected, fact);
        double expected2 = out.minus(c, d);
        double fact2 = c - d;
        assertEquals(expected2, fact2);
    }

    @Test
    public void plusTest() {
        double expected = out.plus(a, b);
        double fact = a + b;
        assertEquals(expected, fact);
        double expected2 = out.plus(c, d);
        double fact2 = c + d;
        assertEquals(expected2, fact2);
    }

    @Test
    public void multiplyTest() {
        double expected = out.multiply(a, b);
        double fact = a * b;
        assertEquals(expected, fact);
        double expected2 = out.multiply(c, d);
        double fact2 = c * d;
        assertEquals(expected2, fact2);
    }

    @Test
    public void divideTest() {
        double expected = out.divide(a, b);
        double fact = a / b;
        assertEquals(expected, fact);
        double expected2 = out.divide(c, d);
        double fact2 = c / d;
        assertEquals(expected2, fact2);
    }

    @Test
    public void divideByZeroTest() {
        assertThrows(DivideByZeroException.class, () -> {
            out.divide(a, zero);
        });
    }

    @Test
    public void answerBuildPlusTest() {
        String expected = a + " " + "+" + " " + b + " = " + out.plus(a, b);
        String fact = out.answerBuild(a, b, "+");
        assertEquals(expected, fact);
    }

    @Test
    public void answerBuildMinusTest() {
        String expected = a + " " + "-" + " " + b + " = " + out.minus(a, b);
        String fact = out.answerBuild(a, b, "-");
        assertEquals(expected, fact);
    }

    @Test
    public void answerBuildMultiplyTest() {
        String expected = a + " " + "*" + " " + b + " = " + out.multiply(a, b);
        String fact = out.answerBuild(a, b, "*");
        assertEquals(expected, fact);
    }

    @Test
    public void answerBuildDivideTest() {
        String expected = a + " " + "/" + " " + b + " = " + out.divide(a, b);
        String fact = out.answerBuild(a, b, "/");
        assertEquals(expected, fact);
    }


    @Test
    public void absenseOneOfParamTest() {
        assertThrows(BadRequiredParamException.class, () -> {
            out.answerBuild(a, null, "/");
        });
    }

    @Test
    public void absenseBothOfParamTest() {
        assertThrows(BadRequiredParamException.class, () -> {
            out.answerBuild(null, null, "/");
        });
    }

}
