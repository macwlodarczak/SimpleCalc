import java.util.Scanner;

public class DataReader {
    private Scanner sc = new Scanner(System.in);
    int takeUsrOptn() {
        int a = sc.nextInt();
        sc.nextLine();
        return a;
    }
    double getUsrNmbr() {
        double a = sc.nextDouble();
        sc.nextLine();
        return a;
    }
}
