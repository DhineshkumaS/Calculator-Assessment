package com.assignment.Calculator.Model;

public class Calculator {
    public double addition(double numOne, double numTwo){
        return numOne + numTwo;
    }
    public double subtraction(double numOne, double numTwo){
        return numOne - numTwo;
    }
    public double multiplicaiton(double numOne, double numTwo){
        return numOne * numTwo;
    }
    public double division(double numOne, double numTwo){
        if(numTwo == 0){
            throw new IllegalArgumentException("Cannot divide by zero. Please try anothor number");
        }
        return numOne / numTwo;
    }
}
