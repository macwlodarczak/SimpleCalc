package logic;

import java.math.BigInteger;

class Calculator {
    double addTwoNumbers(double a, double b) {
        double sum = a + b;
        return sum;
    }
    double subsTwoNumbers(double a, double b) {
        double sum = a - b;
        return sum;
    }
    double multiTwoNumbers(double a, double b) {
        double sum = a * b;
        return sum;
    }
    double divTwoNumbers(double a, double b) {
        double sum = a / b;
        return sum;
    }

    BigInteger factorial(int a) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= a ; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}