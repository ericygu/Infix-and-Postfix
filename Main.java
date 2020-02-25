package com.company;
import java.util.Stack;
//answers to 2, 4 and 5.
//4 and 5 are their separate classes, but I put them both in the main class
public class Main {
    //Question 2
    private static void printElementsInBothArrays(int[] array1, int[] array2) {
        int i = 0;
        int j = 0;
        //while is a boolean
        while (i < array1.length && j < array2.length) {
            //since if, else if, else, print, booleans are constant we can use them and it will still be within the
            //n framework
            //if the number in array1 in that order is less than array 2, print it and check the next one in the array
            if (array1[i] < array2[j]) {
                //have commas to separate each value
                System.out.print(array1[i] + " , ");
                //add one to i so it reads the next thing in the array
                i++;
            }
            //if the array numbers inside are equal, can print both of them because since it is already pre-sorted
            else if (array1[i] == array2[j]) {
                System.out.print("" + array1[i] + " , " + array2[j] + " , ");
                i++;
                //similar logic for j, so that it reads the next item in the array
                j++;
            }

            else {
                System.out.print(array2[j] + " , ");
                j++;
            }
        }

        //these are to make sure the program will function even if the arrays are of different size,
        //or if an array is empty, that it still continues to do the function
        if (i < array1.length && j == array2.length) {
            while(i < array1.length) {
                System.out.print(array1[i] + " , ");
                i++;
            }
        }
        else if (j < array2.length && i == array1.length) {
            while(j < array2.length) {
                System.out.print(array2[j] + " , ");
                j++;
            }
        }

    }

    //Question 4 -- new class
    public static class InfixToPostfix {
        //see question 5 for functionFinder notes
        public static boolean functionFinder(String s) {

            String add = "+";
            String subtract = "-";
            String divide = "/";
            String multiply = "*";


            return s.equals(add) || s.equals(subtract) || s.equals(divide) || s.equals(multiply);
        }

        public static String infixToPostfix(String infixExpression) {

            Stack<String> operands = new Stack<>();
            Stack<String> operators = new Stack<>();
            String[] inputValues = infixExpression.split("\\s");
            //make sure that we get everything in the function to turn it into postfix
            for(int i = 0; i < inputValues.length; i++) {
                String a = "";
                if(functionFinder(inputValues [i])) {
                    operators.push(inputValues[i]);
                }
                else if(inputValues[i].equals("(")){

                }
                else if(inputValues[i].equals(")")){
                    String temp = operands.pop();
                    a += operands.pop();
                    a += temp;
                    a += operators.pop();
                    operands.push(a);
                }
                else {
                    operands.push(inputValues[i]);
                }

            }
            return operands.pop();
        }

    }


    //Question 5 -- new class
    public static class EvaluatePostfix {

        //use a boolean to find in the string a math function, which enables prioritization
        public static boolean functionFinder(String s) {
            //since we don't need to do ^ or sqrt, we use these 4 below to symbolize the mathmatical functions we use
            String add = "+";
            String subtract = "-";
            String divide = "/";
            String multiply = "*";

            //we can find where in the string there is one of these symbols
            return s.equals(add) || s.equals(subtract) || s.equals(divide) || s.equals(multiply);
        }

        private static int evaluatePostfix(String postfixExpression) {

            Stack<String> operands = new Stack<>();
            Stack<String> operators = new Stack<>();
            String[] values = postfixExpression.split("\\s");

            for (int i = 0; i < values.length; i++) {
                if (functionFinder(values[i])) {
                    operators.push(values[i]);
                    //find if the there are operators
                    if (!operands.isEmpty()) {
                        //find the variables used for the operator
                        int variable1 = Integer.parseInt(operands.pop());
                        int variable2 = Integer.parseInt(operands.pop());

                        switch ((values[i])) {
                            //use cases for each string found; break; complete the math function
                            case "+" : operands.push("" + (variable1 + variable2)); break;
                            case "-" : operands.push("" + (variable1 - variable2)); break;
                            case "/" : operands.push("" + (variable1 / variable2)); break;
                            case "*" : operands.push("" + (variable1 * variable2)); break;


                            default: break;
                        }
                    }
                }
                //try to find another operator
                else {
                    operands.push(values[i]);
                }
            }
            //return processed integer
            return Integer.parseInt(operands.pop());
        }
    }

    public static void main(String[] args) {

    }
}
