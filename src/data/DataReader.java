package data;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private Scanner sc = new Scanner(System.in);

    public int takeUsrOptn() {
        int a = -1;
        boolean error = true;
        do {
            try {
                a = sc.nextInt();
                sc.nextLine();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("Please try again");
                sc.nextLine();
            }
        } while (error);
        return a;
    }
    public double getUsrNmbr() {
        boolean error = true;
        double a = 0;
        do {
            try {
                a = sc.nextDouble();
                sc.nextLine();
//                return a;
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("Please try again");
                sc.nextLine();
            }
        } while (error);
        return a;
    }
    public void close() {
        sc.close();
    }
}