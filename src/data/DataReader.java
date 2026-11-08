package data;

import logic.CalcControl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private final Scanner sc = new Scanner(System.in);

    public String takeUsrOptn(String option) {
        String userOption = null;
        boolean error = true;
        if (option.equals(CalcControl.MAIN_MENU_OPTION)) {
            do {
                userOption = sc.nextLine();
                if (!userOption.matches("^(?:[-+=/*!]*|[Ee]xit)$")) {
                    throw new IllegalArgumentException("Please enter correct character or type 'Exit' to quit ");
                } else
                    error = false;
            } while (error);
        } else if (option.equals(CalcControl.NEXT_STEP_OPTION)) {
            do {
                userOption = sc.nextLine();
                if (!userOption.matches("^(?:[-+=]*|[Mm]enu)$")) {
                    throw new IllegalArgumentException("Please enter correct character or type 'Menu' to quit ");
                } else
                    error = false;
            } while (error);

        }
        return userOption;
    }

    public double getUsrNmbr() {
        boolean error = true;
        double a = 0;
        do {
            try {
                a = sc.nextDouble();
                sc.nextLine();
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