package pro.sky.calculatr.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.calculatr.Exception.BadRequiredParamException;
import pro.sky.calculatr.Exception.DivideByZeroException;
import pro.sky.calculatr.Service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greetings(){
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(value = "num1", required = false) Double num1,
                       @RequestParam(value = "num2", required = false) Double num2) {
        return calculatorService.answerBuild(num1, num2,"+");

    }

    @GetMapping("/minus")
    public String minus(@RequestParam(value = "num1", required = false) Double num1,
                        @RequestParam(value = "num2", required = false) Double num2) {
        return calculatorService.answerBuild(num1, num2,"-");

    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Double num1,
                           @RequestParam(value = "num2", required = false) Double num2) {
        return calculatorService.answerBuild(num1, num2, "*");
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(value = "num1", required = false) Double num1,
                         @RequestParam(value = "num2", required = false) Double num2) {
        return calculatorService.answerBuild(num1, num2, "/");

    }

    @ExceptionHandler(DivideByZeroException.class)
    public String DivideByZeroExceptionHandler(DivideByZeroException e){
        return "На 0 делить нельзя";
    }
    @ExceptionHandler(BadRequiredParamException.class)
    public String BadRequiredParamException(BadRequiredParamException e) {
        return "Один или несколько параметров не переданы";
    }



}
