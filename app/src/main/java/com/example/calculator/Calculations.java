package com.example.calculator;

public class Calculations {


    double calculate(double numLeft, double numRight, char op){
        double result = 0.0;
        switch (op){
            case '+':
                result = numLeft + numRight;
                break;
            case '-':
                result = numLeft - numRight;
                break;
            case '*':
                result = numLeft * numRight;
                break;
            case '/':
                result = numLeft / numRight;
            default:
                break;
        }

        return result;

    }
}
