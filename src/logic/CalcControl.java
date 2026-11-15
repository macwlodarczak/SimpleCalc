package logic;

import data.DataReader;

import java.math.BigInteger;

public class CalcControl {
    public static final String MAIN_MENU_OPTION = "Main Menu";
    public static final String NEXT_STEP_OPTION = "Next Step";
    private static final String ADDITION = "+";
    private static final String SUBTRACTION = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";
    private static final String FACTORIAL = "!";
    private static final String EXIT = "Exit";
    private static final String SEE_RESULT = "=";
    private static final String RETURN_TO_MAIN_MENU = "menu";
    private final DataReader dr = new DataReader();
    private final Calculator calc = new Calculator();
    private BigInteger resultBI = BigInteger.valueOf(0);

    public void controlLoop() {
        String option = "";
        do {
            printCalcOptns();
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
                    printResult(resultBI);
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
                printOperationName(operationType);
                double a = getUserNumbers();
                double b = getUserNumbers();
                wynik = calc.addTwoNumbers(a, b);
            }
            case SUBTRACTION -> {
                printOperationName(operationType);
                double a = getUserNumbers();
                double b = getUserNumbers();
                wynik = calc.subsTwoNumbers(a, b);

            }
            case MULTIPLICATION -> {
                printOperationName(operationType);
                double a = getUserNumbers();
                double b = getUserNumbers();
                wynik = calc.multiTwoNumbers(a, b);
            }
            case DIVISION -> {
                printOperationName(operationType);
                double a = getUserNumbers();
                double b = getUserNumbers();
                wynik = calc.divTwoNumbers(a, b);
            }
            case FACTORIAL -> {
                printOperationName(operationType);
                int factorialNmb = (int) getUsersNextNumber();
                BigInteger b = calc.factorial(factorialNmb);
                setResult(b);
            }
            default -> System.out.println("ERROR");
        }
        return wynik;
    }

    private void afterOperationOptions(double result) {
        String nextStep;
        do {
            printNextSteps();
            nextStep = getNextSteps();
            switch (nextStep) {
                case SEE_RESULT -> printResult(result);

                case SUBTRACTION -> {
                    result -= getUserNumbers();
                    printResult(result);
                }
                case ADDITION -> {
                    result += getUserNumbers();
                    printResult(result);
                }
                case MULTIPLICATION -> {
                    result *= getUserNumbers();
                    printResult(result);
                }
                case DIVISION -> {
                    result /= getUserNumbers();
                    printResult(result);
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

    private void printResult(double a) {
        System.out.println("\nResult: " + a + "\n");
    }

    private void printResult(BigInteger a) {
        System.out.println("\nResult: " + a + "\n");
    }

    private void setResult(BigInteger result) {
        this.resultBI = result;
    }

    public void printCalcOptns() {
        System.out.println(">>>simpleCALCULATORv0.1<<<");
        System.out.println("Choose an option:");
        System.out.println("(Type correct sign)" + "\n");
        System.out.println("\"" + ADDITION + "\"" + " for Addition (+)");
        System.out.println("\"" + SUBTRACTION + "\"" + "for Substraction (-)");
        System.out.println("\"" + MULTIPLICATION + "\"" + " for Multiplication (*)");
        System.out.println("\"" + DIVISION + "\"" + " for Division (/)");
        System.out.println("\"" + FACTORIAL + "\"" + " for Factorial (!)");
        System.out.println("type: " + "\"" + EXIT + "\"" + " for Quit");
    }

    private void printNextSteps() {
        System.out.println("Choose next step:");
        System.out.println(SEE_RESULT + " get Result");
        System.out.println(ADDITION + " Add another Number");
        System.out.println(SUBTRACTION + " Substract a Result");
        System.out.println(MULTIPLICATION + " Multiply a Result");
        System.out.println(DIVISION + " Divide a Result");
        System.out.println("type: " + "\"" + RETURN_TO_MAIN_MENU + "\"" + " to return");
    }

    private void printOperationName(String operationType) {
        if (operationType.equals(ADDITION))
            System.out.println("Selected operation: Addition(+)");
        if (operationType.equals(SUBTRACTION))
            System.out.println("Selected operation: Substraction (-)");
        if (operationType.equals(MULTIPLICATION))
            System.out.println("Selected operation: Multiplication (*)");
        if (operationType.equals(DIVISION))
            System.out.println("Selected operation: Division (/)");
        if (operationType.equals(FACTORIAL))
            System.out.println("Selected operation: Factorial (!)");
    }

    private void printPrompt_Enter_a_number() {
        System.out.println("Enter a number");
    }
}