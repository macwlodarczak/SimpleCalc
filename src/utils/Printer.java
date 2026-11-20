package utils;

import logic.CalcControl;

import java.math.BigInteger;

public class Printer {

    public static void printNextSteps() {
        String resultFormat = "%s get Result";
        String resultOutput = String.format(resultFormat, CalcControl.SEE_RESULT);
        String additionFormat = "%s Add another Number";
        String additionOutput = String.format(additionFormat, CalcControl.ADDITION);
        String substractFormat = "%s Substract a Result";
        String substractOutput = String.format(substractFormat, CalcControl.SUBTRACTION);
        String multiplyFormat = "%s Multiply a result";
        String multiplyOutput = String.format(multiplyFormat, CalcControl.MULTIPLICATION);
        String divideFormat = "%s Divide a result";
        String divideOutput = String.format(divideFormat, CalcControl.DIVISION);
        String returnMenuFormat = "type: " + "\"" + "%s" + "\"" + " to return";
        String returnMenuOutput = String.format(returnMenuFormat, "Menu");

        System.out.println("Choose next step:");
        System.out.println(resultOutput);
        System.out.println(additionOutput);
        System.out.println(substractOutput);
        System.out.println(multiplyOutput);
        System.out.println(divideOutput);
        System.out.println(returnMenuOutput);
    }

    public static void printCalcOptns() {
        System.out.println(">>>simpleCALCULATORv0.1<<<");
        System.out.println("Choose an option:");
        System.out.println("(Type correct sign)" + "\n");
        System.out.println("\"" + CalcControl.ADDITION + "\"" + " for Addition (+)");
        System.out.println("\"" + CalcControl.SUBTRACTION + "\"" + "for Substraction (-)");
        System.out.println("\"" + CalcControl.MULTIPLICATION + "\"" + " for Multiplication (*)");
        System.out.println("\"" + CalcControl.DIVISION + "\"" + " for Division (/)");
        System.out.println("\"" + CalcControl.FACTORIAL + "\"" + " for Factorial (!)");
        System.out.println("type: " + "\"Exit\"" + " for Quit");
    }

    public void printOperationName(String operationType) {
        if (operationType.equals(CalcControl.ADDITION))
            System.out.println("Selected operation: Addition(+)");
        if (operationType.equals(CalcControl.SUBTRACTION))
            System.out.println("Selected operation: Substraction (-)");
        if (operationType.equals(CalcControl.MULTIPLICATION))
            System.out.println("Selected operation: Multiplication (*)");
        if (operationType.equals(CalcControl.DIVISION))
            System.out.println("Selected operation: Division (/)");
        if (operationType.equals(CalcControl.FACTORIAL))
            System.out.println("Selected operation: Factorial (!)");
    }

    public void printResult(double a) {
        System.out.println("\nResult: " + a + "\n");
    }

    public void printResult(BigInteger a) {
        System.out.println("\nResult: " + a + "\n");
    }
}