//Eric Gu redo 1

package com.company;

import java.util.Stack;

public class infixToPostfix {
    private static String infixToPostfix(String infixExpression) {
        Stack<String> operands = new Stack<>();
        Stack<String> operators = new Stack<>();
        String[] inputValues = infixExpression.split("\\s");

        for(int i = 0; i < inputValues.length; i++) {
            String string = "";

            if(functionFinder(inputValues [i])) {
                operators.push(inputValues[i]);
            }

            else if(inputValues[i].equals("(")){

            }

            else if(inputValues[i].equals(")")){
                String temp = operands.pop();
                string += operands.pop();
                string += temp;
                string += operators.pop();
                operands.push(string);
            }

            else {
                operands.push(inputValues[i]);
            }

        }

        return operands.pop();

    }
    public static boolean functionFinder(String value) {
        if(value.equals("+") || value.equals("-")||value.equals("*")||value.equals("/")) {
            return true;
        }

        else {
            return false;
        }
    }




}
