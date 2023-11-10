/**
 * Controller package, responsible for handling user input and program logic.
 */
package pl.polsl.mj.controller;

import pl.polsl.mj.view.*;
import pl.polsl.mj.model.*;

/**
 * Controller class, responsible for handling user input and program logic.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.1
 */
public class Controller {
    /**
     * Model object for converting arabic numbers to roman and vice versa.
     */
    private Model model;

    /**
     * View object for displaying messages to the user.
     */
    private View view;

    /**
     * Constructor for Controller class.
     */
    public Controller() {
        model = new Model();
        view = new View();
    }

    /**
     * Method for starting the interactive mode.
     * @param args Arguments passed to the program.
     */
    public void startInteractiveMode(String[] args) {
        view.welcome();
        if (args.length == 1 && args[0].equals("-help")) {
            view.help();
        } else {
            int choice = view.menu();
//            interactiveMode();
        }
        // To implement: logic for each choice.
    }

    /**
     * Method for processing command line arguments.
     * @param args Arguments passed to the program.
     */
    public void processCommandArgs(String[] args) {
        String mode = args[0];
        String number = args[1];
//        view.modePerformed(mode);
        switch (mode) {
            case "-a":
                try {
                    int arabic = Integer.parseInt(number);
                    String roman = model.arabicToRoman(arabic);
                    view.displayResult(roman);
                } catch (NumberFormatException e) {
                    view.displayError("Invalid arabic number. It must be an integer between 1 and 3999.");
                } catch (ModelException e) {
                    view.displayError(e.getMessage());
                }
                break;
            case "-r":
                try {
                    int arabic = model.romanToArabic(number);
                    view.displayResult(arabic);
                } catch (ModelException e) {
                    view.displayError(e.getMessage());
                }
                break;
            default:
                view.displayError("Invalid mode. Please use -a or -r.");
        }
    }
}