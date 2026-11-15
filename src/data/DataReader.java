package data;

import logic.CalcControl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private final Scanner sc = new Scanner(System.in);

    public String takeUsrOptn(String option) {
        if (option.equals(CalcControl.MAIN_MENU_OPTION)) {
            return validateInput("^(?:[-+*/]|[Ee]xit)$", "Please enter correct character or type 'Exit' to quit");
        } else if (option.equals(CalcControl.NEXT_STEP_OPTION)) {
            return validateInput("^(?:[-+=*/]|[Mm]enu)$", "Please enter correct character or type 'Menu' to quit");
        }
        return null;
    }

    private String validateInput(String regex, String errorMessage) {
        String userOption;
        boolean flag = true;
        do {
            userOption = sc.nextLine();
            if (!userOption.matches(regex)) {
                throw new IllegalArgumentException(errorMessage);
            } else
                flag = false;
        } while (flag);
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