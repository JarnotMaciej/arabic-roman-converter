/**
 * View package - responsible for displaying messages to the user.
 */
package pl.polsl.mj.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * View class, responsible for displaying messages to the user.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.1
 */
public class View {
    /**
     * Menu options.
     */
    static final String[] MENU_OPTIONS = {
            "Convert arabic number to roman",
            "Convert roman number to arabic",
            "Exit"
    };

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
        IntStream.range(0, MENU_OPTIONS.length)
                .forEach(i -> System.out.println((i + 1) + ". " + MENU_OPTIONS[i]));

        while (true) {
            try {
                choice = scanner.nextInt();
                if (choice < 1 || choice > MENU_OPTIONS.length) {
                    throw new InputMismatchException();
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input, please try again.");
                scanner.nextLine();
            }
        }
        // TODO: do not throw and catch the same exception in the same method!!!

        return choice;
    }


    /**
     * Displays short help instruction for the program.
     */
    public void help() {
        System.out.println("Help menu.");
    }


    /**
     * Displaying result
     * @param roman roman numeral
     */
    public void displayResult(String roman) {
        System.out.println(roman);
    }

    /**
     * Displaying result
     * @param arabic arabic number
     */
    public void displayResult(int arabic) {
        System.out.println(arabic);
    }

    public void displayError(String s) {
        System.out.println("Error: " + s);
    }
}
