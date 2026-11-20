package logic;

import java.math.BigInteger;

final class Calculator {
    static double addTwoNumbers(double a, double b) {
        double sum = a + b;
        return sum;
    }
    static double subsTwoNumbers(double a, double b) {
        double sum = a - b;
        return sum;
    }
    static double multiTwoNumbers(double a, double b) {
        double sum = a * b;
        return sum;
    }
    static double divTwoNumbers(double a, double b) {
        double sum = a / b;
        return sum;
    }

    static BigInteger factorial(int a) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= a ; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}