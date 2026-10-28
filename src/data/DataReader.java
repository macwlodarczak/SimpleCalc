package data;

import java.util.Scanner;

public class DataReader {

    public DataReader() {
    }
    private Scanner sc = new Scanner(System.in);
    public int takeUsrOptn() {
        int a = sc.nextInt();
        sc.nextLine();
        return a;
    }
    public double getUsrNmbr() {
        double a = sc.nextDouble();
        sc.nextLine();
        return a;
    }
}
