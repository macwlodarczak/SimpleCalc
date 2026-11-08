package logic;

import java.math.BigInteger;

public class Calculator {
    protected double addTwoNumbers(double a, double b) {
        double sum = a + b;
        return sum;
    }
    protected double subsTwoNumbers(double a, double b) {
        double sum = a - b;
        return sum;
    }
    protected double multiTwoNumbers(double a, double b) {
        double sum = a * b;
        return sum;
    }
    protected double divTwoNumbers(double a, double b) {
        double sum = a / b;
        return sum;
    }

    protected BigInteger factorial(int a) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= a ; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}