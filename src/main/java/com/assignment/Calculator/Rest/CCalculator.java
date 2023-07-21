package com.assignment.Calculator.Rest;
import com.assignment.Calculator.Model.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CCalculator{
    private Calculator calculator = new Calculator();
    @RequestMapping("/")
    public ModelAndView showCalculator(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("calculator");
        return modelAndView;
    }
    @GetMapping("/calculator/result")
    public ModelAndView calculate(@RequestParam("numberOne") double numOne, @RequestParam("numberTwo") double numTwo, @RequestParam("operation") String operation,
                            Model theModel){
        double result = 0;
        switch (operation) {
            case "add" -> result = calculator.addition(numOne, numTwo);
            case "sub" -> result = calculator.subtraction(numOne, numTwo);
            case "multiply" -> result = calculator.multiplicaiton(numOne, numTwo);
            case "division" -> {
                if (numTwo == 0) {
                    theModel.addAttribute("error", "Cannot divide any numbers divided by 0");
                    break;
                }
                result = calculator.division(numOne, numTwo);
            }
            default -> result = 0;
        }
        theModel.addAttribute("result", result);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("calculator");
        return modelAndView;
    }
}