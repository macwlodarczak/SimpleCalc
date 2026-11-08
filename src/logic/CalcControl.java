package logic;
import data.DataReader;
import java.math.BigInteger;

public class CalcControl {
    private static final String ADDITION = "+";
    private static final String SUBSTRACTION = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";
    private static final String FACTORIAL = "!";
    private static final String EXIT = "Exit";

    private static final String SEE_RESULT = "=";
    private static final String ADD_ANOTHER_NMB = "+";
    private static final String MAIN_MENU = "menu";

    private static final int ARRAY_MAX_NMB = 2;
    double[] numbers = new double[ARRAY_MAX_NMB];

    private static double result = 0;
    private static double savedResult = 0;
    private BigInteger resultBI = BigInteger.valueOf(0);
    DataReader dr = new DataReader();
    Calculator calc = new Calculator();

    public void controlLoop() {
        String option;
        do {
            printCalcOptns();
            option = dr.takeUsrOptn();

            switch (option) {
                case ADDITION -> {
                    operation(ADDITION);
                    resultOptions();
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
                case EXIT -> dr.close();
                default -> wrongOption();
            }
        }
        while (!option.equals(EXIT));
    }
    public void printCalcOptns() {
        System.out.println(">>>simpleCALCULATORv0.1<<<");
        System.out.println("Choose an option:");
        System.out.println("(Type correct sign)" + "\n");
        System.out.println("\"" + ADDITION + "\"" + " for Addition (+)");
        System.out.println("\"" + SUBSTRACTION + "\"" + "for Substraction (-)");
        System.out.println("\"" + MULTIPLICATION + "\"" + " for Multiplication (*)");
        System.out.println("\"" +DIVISION + "\"" + " for Division (/)");
        System.out.println("\"" + FACTORIAL + "\"" + " for Factorial (!)");
        System.out.println("\"" + EXIT + "\"" + " for Quit");
    }
    private void printNextSteps() {
        System.out.println("Choose next step:");
        System.out.println(SEE_RESULT + " get Result");
        System.out.println(SUBSTRACTION + " Substract a Number");
        System.out.println(ADD_ANOTHER_NMB + " Add another Number");
        System.out.println(MAIN_MENU + " return to Main Manu");
    }
    private String getNextSteps() {
        return dr.takeUsrOptn();
    }

    private double getUsersNextNumber(int a) {
        if (a == 0) {
            System.out.println("Enter a number");
        } else
            System.out.println("Enter a second number");
        double x = dr.getUsrNmbr();
        return x;
    }
    private int getUsersNextNumber() {
        System.out.println("Enter a number");
        int a = (int) dr.getUsrNmbr();
        return a;
    }
    private void operation(String operationName) {

        switch (operationName) {
            case ADDITION -> {
                printOperationName(ADDITION);
                getUserNumbers();
                double sum = getSum();
                setResult(sum);
            }
            case SUBSTRACTION -> {
                printOperationName(SUBSTRACTION);
                getUserNumbers();
                double difference = getDifference();
                setResult(difference);
            }
            case MULTIPLICATION -> {
                printOperationName(MULTIPLICATION);
                getUserNumbers();
                double z = calc.multiTwoNumbers(numbers[0], numbers[1]);
                setResult(z);
            }
            case DIVISION -> {
                printOperationName(DIVISION);
                getUserNumbers();
                double z = calc.divTwoNumbers(numbers[0], numbers[1]);
                setResult(z);
            }
            case FACTORIAL -> {
                printOperationName(FACTORIAL);
                int factorialNmb = getUsersNextNumber();
                BigInteger b = calc.factorial(factorialNmb);
                setResult(b);
            }
            default -> System.out.println("ERROR");
        }
    }
    private void printResult(double a) {
        System.out.println("\nResult: " + a + "\n");
    }

    private void printResult(BigInteger a) {
        System.out.println("\nResult: " + a + "\n");
    }

    private void saveResult() {
        savedResult = result;
    }

    private double returnSum(double nmbr) {
        double a = savedResult + nmbr;
        return a;
    }
    private double returnSubstract(double nmbr) {
        double a = savedResult - nmbr;
        return a;
    }

    private void resultOptions() {
        printNextSteps();
        String a = getNextSteps();
        if (a.equals(SEE_RESULT)) {
            printResult(result);
            resultOptions();
        } else if (a.equals(SUBSTRACTION)) {
            saveResult();
            double x = getUsersNextNumber();
            result =  returnSubstract(x);
            printResult(result);
            resultOptions();
        }

        else if (a.equals(ADD_ANOTHER_NMB)) {
            saveResult();
            double x = getUsersNextNumber();
            result = returnSum(x);
            printResult(result);
            resultOptions();
        }
        else if (a.equals(MAIN_MENU)) {
            printResult(result);
        }
        else {
            System.out.println("Wrong option");
            printResult(result);
        }
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

    private void printOperationName(String operationNmb) {
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
    private void getUserNumbers() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = getUsersNextNumber(i);
        }
    }
    private double getSum() {
        return calc.addTwoNumbers(numbers[0], numbers[1]);
    }
    private double getDifference() {
        return calc.subsTwoNumbers(numbers[0], numbers[1]);
    }
}