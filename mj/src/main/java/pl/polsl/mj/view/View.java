package pl.polsl.mj.view;

import java.util.Scanner;


/**
 *
 * @author mj300741@student.polsl.pl
 * @version 1.0
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
    public int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose one of the following options:");
        System.out.println("1. Convert arabic number to roman");
        System.out.println("2. Convert roman number to arabic");
        System.out.println("3. Exit");
        int choice = scanner.nextInt();
        return choice;
    }
}
