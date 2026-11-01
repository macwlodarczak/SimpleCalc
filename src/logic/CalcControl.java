package logic;

import data.DataReader;

import java.math.BigInteger;

public class CalcControl {

    private static final int ADDITION = 1;
    private static final int SUBSTRACTION = 2;
    private static final int MULTIPLICATION = 3;
    private static final int DIVISION = 4;
    private static final int FACTORIAL = 5;
    private static final int EXIT = 6;
    private double result = 0;
    private BigInteger resultBI = BigInteger.valueOf(0);
    DataReader dr = new DataReader();
    Calculator calc = new Calculator();

    public void controlLoop() {
        int option;
        do {
            printCalcOptns();
            option = dr.takeUsrOptn();

            switch(option) {
                case ADDITION -> {
                    operation(ADDITION);
                    printResult(result);
                }
                case SUBSTRACTION -> {
                    operation(SUBSTRACTION);
                    printResult(result);
                }
                case MULTIPLICATION -> {
                    operation(MULTIPLICATION);
                    printResult(result);
                }
                case DIVISION -> {
                    operation(DIVISION);
                    printResult(result);
                }
                case FACTORIAL -> {
                    operation(FACTORIAL);
                    printResult(resultBI);
                }
                case EXIT ->
                    dr.close();
                default ->
                    wrongOption();
            }
        }
        while (option != EXIT);
    }
    private void printCalcOptns() {
        System.out.println(">>>simpleCALCULATORv0.1<<<");
        System.out.println("Choose option:");
        System.out.println(ADDITION + " Addition (+)");
        System.out.println(SUBSTRACTION + " Substraction (-)");
        System.out.println(MULTIPLICATION + " Multiplication (*)");
        System.out.println(DIVISION + " Division (/)");
        System.out.println(FACTORIAL + " Factorial (!)");
        System.out.println(EXIT + " Quit");
    }
    private double getUsrNumber(int a) {
        if (a == 0) {
            System.out.println("Enter a number");
        } else
            System.out.println("Enter a second number");
        double x = dr.getUsrNmbr();
        return x;
    }

    private int getUsrNumber() {
        System.out.println("Enter a number");
        int a = (int) dr.getUsrNmbr();
        return a;
    }

    private void operation(int a) {
        double[] numbers = new double[2];
        if(a == ADDITION){
            printOperationName(ADDITION);
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = getUsrNumber(i);
            }
            double z = calc.addTwoNumbers(numbers[0], numbers[1]);
            setResult(z);
        } else if (a == SUBSTRACTION) {
            printOperationName(SUBSTRACTION);
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = getUsrNumber(i);
            }
            double z = calc.subsTwoNumbers(numbers[0], numbers[1]);
            setResult(z);
        } else if (a == MULTIPLICATION) {
            printOperationName(MULTIPLICATION);
            for(int i = 0; i < numbers.length; i++) {
                numbers[i] = getUsrNumber(i);
            }
            double z = calc.multiTwoNumbers(numbers[0], numbers[1]);
            setResult(z);
        } else if (a == DIVISION) {
            printOperationName(DIVISION);
            for(int i = 0; i < numbers.length; i++) {
                numbers[i] = getUsrNumber(i);
            }
            double z = calc.divTwoNumbers(numbers[0], numbers[1]);
            setResult(z);
        } else if (a == FACTORIAL) {
            printOperationName(FACTORIAL);
            int factorialNmb = getUsrNumber();
            BigInteger b = calc.factorial(factorialNmb);
            setResult(b);
        }
        else
            System.out.println("ERROR");
    }
    private void printResult(double a) {
        System.out.println("\nResult: " + a + "\n");
    }

    private void printResult(BigInteger a){
        System.out.println("\nResult: " + a + "\n");
    }

    private void setResult(double result) {
        this.result = result;
    }

    private void setResult(BigInteger result) {
        this.resultBI = result;
    }

    private void wrongOption() {
        System.out.println("\nWrong option\n");
    }

    private void printOperationName(int operationNmb) {
        if (operationNmb == ADDITION)
            System.out.println("Selected operation: Addition(+)");
        if (operationNmb == SUBSTRACTION)
            System.out.println("Selected operation: Substraction (-)");
        if (operationNmb == MULTIPLICATION)
            System.out.println("Selected operation: Multiplication (*)");
        if (operationNmb == DIVISION)
            System.out.println("Selected operation: Division (/)");
        if (operationNmb == FACTORIAL)
            System.out.println("Selected operation: Factorial (!)");
        }
    }