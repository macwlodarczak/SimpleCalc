public class CalcControl {

    private static final int ADDITION = 1;
    private static final int SUBSTRACTION = 2;
    private static final int MULTIPLICATION = 3;
    private static final int DIVISION = 4;
    private static final int EXIT = 5;
    private double result = 0;
    DataReader dr = new DataReader();
    Calculator calc = new Calculator();

    void controlLoop() {
        int option;
        do {
            printCalcOptns();
            option = dr.takeUsrOptn();

            switch(option) {
                case ADDITION:
                    smthngTwoNumber(ADDITION);
                    printResult(result);
                    break;
                case SUBSTRACTION:
                    smthngTwoNumber(SUBSTRACTION);
                    printResult(result);
                    break;
                case MULTIPLICATION:
                    smthngTwoNumber(MULTIPLICATION);
                    printResult(result);
                    break;
                case DIVISION:
                    smthngTwoNumber(DIVISION);
                    printResult(result);
                    break;
                default:
                    wrongOption();
            }
        }
        while (option != EXIT);
    }
    private void printCalcOptns() {
        System.out.println("Wybierz opcję:");
        System.out.println(ADDITION + " Dodawanie");
        System.out.println(SUBSTRACTION + " Odejmowanie");
        System.out.println(MULTIPLICATION + " Mnożenie");
        System.out.println(DIVISION + " Dzielenie");
    }
    private double getUsrNumber(int a) {
        if (a == 0) {
            System.out.println("Podaj pierwszą liczbę");
        } else
            System.out.println("Podaj drugą liczbę");
        double x = dr.getUsrNmbr();
        return x;
    }
    private void smthngTwoNumber(int a) {
        double[] number = new double[2];
        if(a == ADDITION){
            for (int i = 0; i < number.length; i++) {
                number[i] = getUsrNumber(i);
            }
            double z = calc.addTwoNumbers(number[0], number[1]);
            setResult(z);
        } else if (a == SUBSTRACTION) {
            for (int i = 0; i < number.length; i++) {
                number[i] = getUsrNumber(i);
            }
            double z = calc.subsTwoNumbers(number[0], number[1]);
            setResult(z);
        } else if (a == MULTIPLICATION) {
            for(int i = 0; i < number.length; i++) {
                number[i] = getUsrNumber(i);
            }
            double z = calc.multiTwoNumbers(number[0], number[1]);
            setResult(z);
        } else if (a == DIVISION) {
            for(int i = 0; i < number.length; i++) {
                number[i] = getUsrNumber(i);
            }
            double z = calc.divTwoNumbers(number[0], number[1]);
            setResult(z);
        } else
            System.out.println("ERROR");
    }
    private void printResult(double a) {
        System.out.println("\nWynik to: ");
        System.out.println(a + "\n");
    }
    private void setResult(double result) {
        this.result = result;
    }
    private void wrongOption() {
        System.out.println("\nBłędnie wybrana opcja\n");
    }
}
