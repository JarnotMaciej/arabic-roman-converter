/**
 * Main package, responsible for running the program.
 */
package pl.polsl.mj;

import pl.polsl.mj.controller.*;
import pl.polsl.mj.model.ModelException;

/**
 * Main class, responsible for running the program.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.1
 */
public class Main {
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
            mainController.processCommandArgs(args);
        }
    }
}

// arabic to roman -a 15
// roman to arabic -r XV