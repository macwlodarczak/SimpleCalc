package logic;
import data.DataReader;
import java.math.BigInteger;

public class CalcControl {
    private static final String ADDITION = "+";
    private static final String SUBTRACTION = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";
    private static final String FACTORIAL = "!";
    private static final String EXIT = "Exit";

    private static final String SEE_RESULT = "=";
    private static final String RETURN_TO_MAIN_MENU = "menu";
    public static final String MAIN_MENU_OPTION = "Main Menu";
    public static final String NEXT_STEP_OPTION = "Next Step";

    private static final int ARRAY_MAX_NMB = 2;
    private final double[] numbers = new double[ARRAY_MAX_NMB];

    private double result = 0;
    private double savedResult = 0;
    private BigInteger resultBI = BigInteger.valueOf(0);
    private final DataReader dr = new DataReader();
    private final Calculator calc = new Calculator();

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
                    operation(ADDITION);
                    resultOptions();
                }
                case SUBTRACTION -> {
                    operation(SUBTRACTION);
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
//                default -> wrongOption();
            }
        }
        while (!option.equals(EXIT));
    }
    public void printCalcOptns() {
        System.out.println(">>>simpleCALCULATORv0.1<<<");
        System.out.println("Choose an option:");
        System.out.println("(Type correct sign)" + "\n");
        System.out.println("\"" + ADDITION + "\"" + " for Addition (+)");
        System.out.println("\"" + SUBTRACTION + "\"" + "for Substraction (-)");
        System.out.println("\"" + MULTIPLICATION + "\"" + " for Multiplication (*)");
        System.out.println("\"" +DIVISION + "\"" + " for Division (/)");
        System.out.println("\"" + FACTORIAL + "\"" + " for Factorial (!)");
        System.out.println("type: " + "\"" + EXIT + "\"" + " for Quit");
    }
    private void printNextSteps() {
        System.out.println("Choose next step:");
        System.out.println(SEE_RESULT + " get Result");
        System.out.println(SUBTRACTION + " Substract a Result");
        System.out.println(ADDITION + " Add another Number");
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
            case SUBTRACTION -> {
                printOperationName(SUBTRACTION);
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
    private String getNextSteps() {
        String userOption = "";
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
        switch (a) {
            case SEE_RESULT -> {
                printResult(result);
                resultOptions();
            }
            case SUBTRACTION -> {
                saveResult();
                double x = getUsersNextNumber();
                result = returnSubstract(x);
                printResult(result);
                resultOptions();
            }
            case ADDITION -> {
                saveResult();
                double x = getUsersNextNumber();
                result = returnSum(x);
                printResult(result);
                resultOptions();
            }
            case RETURN_TO_MAIN_MENU -> printResult(result);
            default -> {
                printResult(result);
                resultOptions();
            }
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