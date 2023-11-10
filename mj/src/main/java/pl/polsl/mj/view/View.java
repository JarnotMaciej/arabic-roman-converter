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
        String input;

        System.out.println("Please choose one of the following options:");
        IntStream.range(0, MENU_OPTIONS.length)
                .forEach(i -> System.out.println((i + 1) + ". " + MENU_OPTIONS[i]));

        while (true) {
            input = scanner.next();

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please try again.");
                scanner.nextLine();
                continue;
            }

            if (choice < 1 || choice > MENU_OPTIONS.length) {
                System.out.println("Invalid input, please try again.");
                scanner.nextLine();
            } else {
                break;
            }

        }

        return choice;
    }


    /**
     * Displays short help instruction for the program.
     */
    public void help() {
        System.out.println("Help menu.");
    }


    /**
     * Method for displaying text.
     * @param input Content to be displayed.
     */
    public void display(Object input) {
        System.out.println(input);
    }

    /**
     * Displaying error
     * @param s error message
     */
    public void displayError(String s) {
        System.out.println("Error: " + s);
    }

    /**
     * Getting input from user
     * @return input from user
     */
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
