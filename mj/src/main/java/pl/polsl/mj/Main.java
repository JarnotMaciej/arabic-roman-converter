/**
 * Main package, responsible for running the program.
 */
package pl.polsl.mj;

import pl.polsl.mj.controller.*;
import pl.polsl.mj.model.ModelException;
import pl.polsl.mj.view.View;

/**
 * Main class, responsible for running the program.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.1
 */
public class Main {
    static View view = new View();

    /**
     * Main method for getting & writing out the parameters.
     * 
     * @param args program call parameters
     */
    public static void main(String[] args) throws ModelException {
        Controller mainController = new Controller();
        if (args.length < 2){
            mainController.startInteractiveMode(args);

        } else {
            try {
                mainController.processCommandArgs(args);
            } catch (ModelException e) {
                view.displayError(e.getMessage());
            }
        }
    }
}

// arabic to roman -a 15
// roman to arabic -r XV