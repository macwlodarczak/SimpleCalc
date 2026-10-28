package logic;

import java.math.BigInteger;

public class Calculator {
    public double addTwoNumbers(double a, double b) {
        double sum = a + b;
        return sum;
    }
    public double subsTwoNumbers(double a, double b) {
        double sum = a - b;
        return sum;
    }
    public double multiTwoNumbers(double a, double b) {
        double sum = a * b;
        return sum;
    }
    public double divTwoNumbers(double a, double b) {
        double sum = a / b;
        return sum;
    }

    public BigInteger factorial(int a) {
//        long result = 1;
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= a ; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}