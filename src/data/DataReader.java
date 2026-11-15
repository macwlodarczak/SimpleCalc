package data;

import logic.CalcControl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private final Scanner sc = new Scanner(System.in);

    private static final String MAIN_MENU_USER_INPUT_VALIDATION = "^(?:[-+*/]|[Ee]xit)$";
    private static final String MAIN_MENU_ERROR_MSG = "Please enter correct character or type 'Exit' to quit";

    private static final String NEXT_STEP_USER_INPUT_VALIDATION = "^(?:[-+=*/]|[Mm]enu)$";
    private static final String NEXT_STEP_ERROR_MSG = "Please enter correct character or type 'Menu' to quit";

    public String takeUsrOptn(String option) {
        if (option.equals(CalcControl.MAIN_MENU_OPTION)) {
            return validateInput(MAIN_MENU_USER_INPUT_VALIDATION, MAIN_MENU_ERROR_MSG);
        } else if (option.equals(CalcControl.NEXT_STEP_OPTION)) {
            return validateInput(NEXT_STEP_USER_INPUT_VALIDATION, NEXT_STEP_ERROR_MSG);
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