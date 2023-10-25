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
     */
    public void startInteractiveMode() {
        view.welcome();
        int choice = view.menu();
        // To implement: logic for each choice.
    }

    /**
     * Method for processing command line arguments.
     * @param args Arguments passed to the program.
     */
    public void processCommandArgs(String[] args) {
//        view.printCommandArgs(args);
        // To implement: logic to process the command line arguments.
        switch (args[0]) {
            case "-a":
                System.out.println("Arabic to Roman conversion");
                break;
            case "-r":
                System.out.println("Roman to Arabic conversion");
                break;
            case "help":
                view.help();
                break;
            default:
                System.out.println("Invalid first argument.");
                break;
        }
    }
}