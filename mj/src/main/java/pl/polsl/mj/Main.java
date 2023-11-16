package pl.polsl.mj;

import javax.swing.JFrame;
import pl.polsl.mj.view.*;

/**
 * Main class, responsible for running the program.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.1
 */
public class Main {


/**
 * Method responsible for creating and showing GUI.
 */
    private static void createAndShowGUI() {        
        // JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        View newContentPane = new View();
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }
	
/**
 * Main method, responsible for running the program.
 * @param args the command line arguments -> not used
*/
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}