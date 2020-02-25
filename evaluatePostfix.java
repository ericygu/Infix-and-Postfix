//Eric Gu redo 1

package com.company;

import java.util.Stack;

public class evaluatePostfix {
    private static int evaluatePostfix(String postfixExpression){
        Stack<String> operands = new Stack<>(); //only need one stack
        String[] values = postfixExpression.split("\\s");
        double a;
        double b;
        for(int i = 0; i< values.length; i++){
            switch(values[i]){
                case "*":
                    a = Double.parseDouble(operands.pop());
                    b = Double.parseDouble(operands.pop());
                    operands.push(Double.toString(a*b));
                    break;
                case "/":
                    a = Double.parseDouble(operands.pop());
                    b = Double.parseDouble(operands.pop());
                    operands.push(Double.toString(b/a));
                    break;
                case "+":
                    a = Double.parseDouble(operands.pop());
                    b = Double.parseDouble(operands.pop());
                    operands.push(Double.toString(a+b));
                    break;
                case "-":
                    a = Double.parseDouble(operands.pop());
                    b = Double.parseDouble(operands.pop());
                    operands.push(Double.toString(b-a));
                    break;
                default:
                    operands.push(values[i]);
                    break;
            }
        }
        double j = Double.parseDouble(operands.pop());
        return (int) Math.round(j);
    }
}
