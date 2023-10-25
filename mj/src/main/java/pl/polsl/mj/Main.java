package pl.polsl.mj;

import java.util.Scanner;
import pl.polsl.mj.view.*;


/**
 *
 * @author mj300741@student.polsl.pl
 * @version 1.0
 */
public class Main {
    /**
     * Main method for getting & writing out the parameters.
     * 
     * @param args program call parameters
     */
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        View mainView = new View();
        mainView.welcome();
        int choice = mainView.menu();
        if (args.length == 0){
            // interactive mode
        } else {
            for (int i = 0; i < args.length; i++) {
                System.out.println("parameter " + (i + 1) + ":" + args[i]);
            }
        }
        
// arabic to roman -a 15
// roman to arabic -r XV
    }
}
