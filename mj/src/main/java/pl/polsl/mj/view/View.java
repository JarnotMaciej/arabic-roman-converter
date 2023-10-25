package pl.polsl.mj.view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * View class, responsible for displaying messages to the user.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.1
 */
public class View {    
    /**
     * Welcome message
     */
    public void welcome() {
        System.out.println("Hello, welcome to arabic-roman converter application!");
    }

    /**
     * Displaying menu
     * @return choice
     */
    public int menu() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        System.out.println("Please choose one of the following options:");
        System.out.println("1. Convert arabic number to roman");
        System.out.println("2. Convert roman number to arabic");
        System.out.println("3. Exit");

        while (true) {
            try {
                choice = scanner.nextInt();
                if (choice < 1 || choice > 3) {
                    throw new InputMismatchException();
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input, please try again.");
                scanner.nextLine();
            }
        }

        return choice;
    }

    /**
     * Function used for debugging, it prints all the arguments passed to the program
     * @param args Arguments passed to the program.
     */
    public void printCommandArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("parameter " + (i + 1) + ": " + args[i]);
        }
    }

    /**
     * Displays short help instruction for the program.
     */
    public void help() {
        System.out.println("Help menu.");
    }
}
