package pro.sky.calculatr.Service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pro.sky.calculatr.Constants.CalculatorServiceTestConstants.*;

public class CalculatorServiceParametrizedTest {

    private final CalculatorService out = new CalculatorService();

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void minusTest(double firstNum, double secondNum) {
        double expected = out.minus(firstNum, secondNum);
        double fact = firstNum - secondNum;
        assertEquals(expected, fact);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void plusTest(double firstNum, double secondNum) {
        double expected = out.plus(firstNum, secondNum);
        double fact = firstNum + secondNum;
        assertEquals(expected, fact);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void multiplyTest(double firstNum, double secondNum) {
        double expected = out.multiply(firstNum, secondNum);
        double fact = firstNum * secondNum;
        assertEquals(expected, fact);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void divideTest(double firstNum, double secondNum) {
        double expected = out.divide(firstNum, secondNum);
        double fact = firstNum / secondNum;
        assertEquals(expected, fact);
    }


    public static Stream<Arguments> provideParamsForTests() {
        return Stream.of(
                Arguments.of(a, b),
                Arguments.of(c, d)
        );
    }


}
