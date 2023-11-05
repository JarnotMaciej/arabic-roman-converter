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
    private Model model;
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
        if (args.length == 1) {
            view.modePerformed(args[0]);
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
        view.modePerformed(mode);
    }
}