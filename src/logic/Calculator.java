package logic;

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

    public long factorial(int a) {
        long result = 1;
        for (int i = 1; i <= a ; i++) {
            result *= i;
        }
        return result;
    }
}