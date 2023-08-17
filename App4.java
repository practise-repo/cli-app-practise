import java.util.Scanner;
public class App4 {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        final String CLEAR = "\033[H\033[2J";
        final String COLOUR_BLUE_BOLD = "\033[34;1m";
        final String COLOUR_RED_BOLD = "\033[31;1m";
        final String COLOUR_GREEN_BOLD = "\033[33;1m";
        final String RESET = "\033[0m";

        final String DASHBOARD = "Welcome to DEP-11 Phase-1 Assignment Marks Collector";
        final String ADD_ASSIGNMENT_MARKS = "Add Assignment Marks";
        final String PRINT_DETAILS = "Print Assignment Marks";

        final String ERROR_MSG = String.format("%s%s%s\n", COLOUR_RED_BOLD, "%s", RESET);
        final String SUCCS_MSG = String.format("\t%s%s%s\n", COLOUR_GREEN_BOLD, "%s", RESET);

        String screen = DASHBOARD;

        String[][] students = new String[][]{  
            { "DEP-01", "Kasun", "75" },
            { "DEP-02", "Nuwan", "32.25" },
            { "DEP-03", "Ruwan", "65" },
            { "DEP-04", "Upul", "100" },
            { "DEP-05", "Supun", "58" },
            { "DEP-06", "Tharindu", "88.21" }
    };




        final String APP_TITLE = String.format("%s%s%s", COLOUR_BLUE_BOLD, screen, RESET);

        do {
            System.out.println(CLEAR);
            System.out.printf("%s%s\n", APP_TITLE, RESET);

            switch (screen) {
                case DASHBOARD:
                    System.out.println("[1] Add Assignment Marks:");
                    System.out.println("[2] Print Assignment Marks");
                    System.out.println("[3] Exit");
                    System.out.print("Enter an Option to Continue: ");
                    int option = SCANNER.nextInt();
                    SCANNER.nextLine();

                    switch (option) {

                        case 1:
                            screen = ADD_ASSIGNMENT_MARKS;
                            break;

                        case 2:
                            screen = PRINT_DETAILS;
                            break;

                        case 3:
                            System.exit(0);
                            break;

                        default:
                            continue;
                    }
                    break;

                case ADD_ASSIGNMENT_MARKS:

                    boolean valid;

                    do {
                        valid = true;
                        System.out.print("Enter Student ID: ");
                        String id = SCANNER.nextLine().strip().toUpperCase();

                        if (id.isEmpty()) {
                            valid = false;
                            System.out.printf("%s Id can't be Empty %s\n", COLOUR_RED_BOLD, RESET);
                            continue;
                        }
                        if (!id.startsWith("DEP-") || id.length() != 6) {
                            System.out.printf("%s Invalid Format %s\n", COLOUR_RED_BOLD, RESET);
                            valid = false;
                            continue;
                        } 
                        else{
                            String numberPart = id.substring(5);
                            for (int i = 0; i < numberPart.length(); i++) {
                                if (!Character.isDigit(numberPart.charAt(i))) {

                                    System.out.printf("%s Invalid  Format.Nodigit %s\n", COLOUR_RED_BOLD, RESET);
                                    valid = false;
                                    continue;
                                }

                            }

                            /*Already Exists */

                            for (int i = 0; i < students.length; i++) {
                                if(students[i][0].equals(id))
                                {
                                    valid=false;
                                    System.out.printf(ERROR_MSG,"Already Exists");
                                    continue;
                                }
                            }
                        }

                    } while (!valid);

                    System.out.println("Valid Ok");
                    SCANNER.nextLine();
                   

            }
        } while (true);

    }
}