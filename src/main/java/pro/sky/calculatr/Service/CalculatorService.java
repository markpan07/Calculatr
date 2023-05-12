package pro.sky.calculatr.Service;

import org.springframework.stereotype.Service;
import pro.sky.calculatr.Exception.BadRequiredParamException;
import pro.sky.calculatr.Exception.DivideByZeroException;

@Service
public class CalculatorService {

    public double plus(double a, double b) {
        return a + b;
    }

    public double minus(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) throws DivideByZeroException {
        if (b == 0) {
            throw new DivideByZeroException();
        }
        return a / b;
    }

    public String answerBuild(Double num1, Double num2, String operation) {
        if (num1 == null || num2 == null) {
            throw new BadRequiredParamException();
        }
        Number result;
        switch (operation) {
            case "-":
                result = minus(num1, num2);
                break;
            case "+":
                result = plus(num1, num2);
                break;
            case "/":
                result = divide(num1, num2);
                break;
            default:
                result = multiply(num1, num2);
                break;
        }

        return num1 + " " + operation + " " + num2 + " = " + result;
    }
}
