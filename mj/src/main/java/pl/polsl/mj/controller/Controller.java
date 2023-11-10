/**
 * Controller package, responsible for handling user input and program logic.
 */
package pl.polsl.mj.controller;

import pl.polsl.mj.model.Model;
import pl.polsl.mj.model.ModelException;
import pl.polsl.mj.view.View;

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
    private final Model model;

    /**
     * View object for displaying messages to the user.
     */
    private final View view;

    /**
     * Constructor for Controller class.
     */
    public Controller() {
        model = new Model();
        view = new View();
    }

    /**
     * Method for starting the interactive mode.
     *
     * @param args Arguments passed to the program.
     */
    public void startInteractiveMode(String[] args) throws ModelException {
        view.welcome();
        if (args.length == 1 && args[0].equals("-help")) {
            view.help();
        } else {
            int choice = view.menu();
            switch (choice) {
                case 1:
                    String arabicNumeral;
                    view.display("Please enter an arabic number: ");
                    while (true) {
                        arabicNumeral = view.getInput();
                        if (model.validate(true, arabicNumeral)) {
                            break;
                        }
                        view.displayError("Invalid arabic number. It must be an integer between 1 and 3999.");
                    }
                    view.display("Roman numeral: " +model.arabicToRoman(Integer.parseInt(arabicNumeral)));
                    break;
                case 2:
                    String romanNumeral;
                    view.display("Please enter a roman number: ");
                    while (true) {
                        romanNumeral = view.getInput();
                        if (model.validate(false, romanNumeral)) {
                            break;
                        }
                        view.displayError("Invalid roman number. It must be a valid roman numeral.");
                    }
                    view.display("Arabic numeral: " + model.romanToArabic(romanNumeral));
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    view.displayError("Invalid choice. Please choose one of the following options:");
            }
            view.display("Quitting...");
        }
    }

    /**
     * Method for processing command line arguments.
     *
     * @param args Arguments passed to the program.
     */
    public void processCommandArgs(String[] args) {
        String mode = args[0];
        String number = args[1];
        switch (mode) {
            case "-a":
                try {
                    if (!model.validate(true, number)) {
                        throw new ModelException("Invalid arabic number. It must be an integer between 1 and 3999.");
                    }
                    view.display(model.arabicToRoman(Integer.parseInt(number)));
                } catch (NumberFormatException e) {
                    view.displayError("Invalid arabic number. It must be an integer between 1 and 3999.");
                } catch (ModelException e) {
                    view.displayError(e.getMessage());
                }
                break;
            case "-r":
                try {
                    if (!model.validate(false, number)) {
                        throw new ModelException("Invalid roman number. It must be a valid roman numeral.");
                    }
                    view.display(model.romanToArabic(number));
                } catch (NumberFormatException e) {
                    view.displayError("Invalid roman number. It must be a valid roman numeral.");
                } catch (ModelException e) {
                    view.displayError(e.getMessage());
                }
                break;
            default:
                view.displayError("Invalid mode. Please use -a or -r.");
        }
    }
}