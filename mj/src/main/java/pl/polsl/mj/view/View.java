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
        displayAsciiArt();
        System.out.println("Hello, welcome to arabic-roman converter application!");
    }

    /**
     * Displaying ascii art
     */
        public void displayAsciiArt() {
            String asciiArt = """
                
                ░█▀█░█▀▄░█▀█░█▀▄░▀█▀░█▀▀░░░░░█▀▄░█▀█░█▄█░█▀█░█▀█░░░█▀▀░█▀█░█▀█░█░█░█▀▀░█▀▄░▀█▀░█▀▀░█▀▄
                ░█▀█░█▀▄░█▀█░█▀▄░░█░░█░░░▄▄▄░█▀▄░█░█░█░█░█▀█░█░█░░░█░░░█░█░█░█░▀▄▀░█▀▀░█▀▄░░█░░█▀▀░█▀▄
                ░▀░▀░▀░▀░▀░▀░▀▀░░▀▀▀░▀▀▀░░░░░▀░▀░▀▀▀░▀░▀░▀░▀░▀░▀░░░▀▀▀░▀▀▀░▀░▀░░▀░░▀▀▀░▀░▀░░▀░░▀▀▀░▀░▀
                
            """;

            System.out.println(asciiArt);
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
     * Function used for displaying which mode of program will be performed.
     * @param flag Flag which is used to determine which mode will be performed.
     */
    public void modePerformed(String flag) {
        switch (flag) {
            case "-a":
                System.out.println("Arabic to Roman conversion");
                break;
            case "-r":
                System.out.println("Roman to Arabic conversion");
                break;
                case "-help":
                help();
                break;
            default:
                System.out.println("Invalid first argument, try '-help' for more information how to use this program.");
                break;
        }
    }

    /**
     * Displays short help instruction for the program.
     */
    public void help() {
        System.out.println("Help menu.");
    }
}
