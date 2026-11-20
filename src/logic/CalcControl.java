package logic;

import data.DataReader;
import utils.Printer;

import java.math.BigInteger;

public class CalcControl {
    public static final String MAIN_MENU_OPTION = "Main Menu";
    public static final String NEXT_STEP_OPTION = "Next Step";
    public static final String ADDITION = "+";
    public static final String SUBTRACTION = "-";
    public static final String MULTIPLICATION = "*";
    public static final String DIVISION = "/";
    public static final String FACTORIAL = "!";
    public static final String EXIT = "EXIT";
    public static final String SEE_RESULT = "=";
    public static final String RETURN_TO_MAIN_MENU = "MENU";

    private final Printer printer = new Printer();
    private final DataReader dr = new DataReader();
    private BigInteger resultBI = BigInteger.valueOf(0);

    public void controlLoop() {
        String option = "";
        do {
            Printer.printCalcOptns();
            try {
                option = dr.takeUsrOptn(MAIN_MENU_OPTION);
            } catch (IllegalArgumentException ex) {
                System.err.println(ex.getMessage());
            }

            switch (option) {
                case ADDITION -> {
                    double a = operation(option);
                    afterOperationOptions(a);
                }
                case SUBTRACTION -> {
                    double a = operation(option);
                    afterOperationOptions(a);
                }
                case MULTIPLICATION -> {
                    double a = operation(option);
                    afterOperationOptions(a);
                }
                case DIVISION -> {
                    double a = operation(option);
                    afterOperationOptions(a);
                }
                case FACTORIAL -> {
                    operation(FACTORIAL);
                    printer.printResult(resultBI);
                }
                case EXIT -> dr.close();
            }
        }
        while (!option.equals(EXIT));
    }

    private double operation(String operationType) {
        double wynik = 0;

        switch (operationType) {
            case ADDITION -> {
                printer.printOperationName(operationType);
                double a = getUserNumbers();
                double b = getUserNumbers();
                wynik = Calculator.addTwoNumbers(a, b);
            }
            case SUBTRACTION -> {
                printer.printOperationName(operationType);
                double a = getUserNumbers();
                double b = getUserNumbers();
                wynik = Calculator.subsTwoNumbers(a, b);

            }
            case MULTIPLICATION -> {
                printer.printOperationName(operationType);
                double a = getUserNumbers();
                double b = getUserNumbers();
                wynik = Calculator.multiTwoNumbers(a, b);
            }
            case DIVISION -> {
                printer.printOperationName(operationType);
                double a = getUserNumbers();
                double b = getUserNumbers();
                wynik = Calculator.divTwoNumbers(a, b);
            }
            case FACTORIAL -> {
                printer.printOperationName(operationType);
                int factorialNmb = (int) getUsersNextNumber();
                BigInteger b = Calculator.factorial(factorialNmb);
                setResult(b);
            }
            default -> System.out.println("ERROR");
        }
        return wynik;
    }

    private void afterOperationOptions(double result) {
        String nextStep;
        do {
            Printer.printNextSteps();
            nextStep = getNextSteps();
            switch (nextStep) {
                case SEE_RESULT -> printer.printResult(result);

                case SUBTRACTION -> {
                    result -= getUserNumbers();
                    printer.printResult(result);
                }
                case ADDITION -> {
                    result += getUserNumbers();
                    printer.printResult(result);
                }
                case MULTIPLICATION -> {
                    result *= getUserNumbers();
                    printer.printResult(result);
                }
                case DIVISION -> {
                    result /= getUserNumbers();
                    printer.printResult(result);
                }
            }
        } while (!nextStep.equals(RETURN_TO_MAIN_MENU));
    }

    private double getUsersNextNumber() {
        return dr.getUsrNmbr();
    }

    private double getUserNumbers() {
        printPrompt_Enter_a_number();
        return dr.getUsrNmbr();
    }

    private String getNextSteps() {
        String userOption = null;
        try {
            userOption = dr.takeUsrOptn(NEXT_STEP_OPTION);
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        return userOption;
    }

    private void setResult(BigInteger result) {
        this.resultBI = result;
    }

    private void printPrompt_Enter_a_number() {
        System.out.println("Enter a number");
    }
}