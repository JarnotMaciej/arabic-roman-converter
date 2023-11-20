package pl.polsl.mj;

import pl.polsl.mj.view.*;

import javax.swing.*;
import static javax.swing.UIManager.setLookAndFeel;

/**
 * Main class, responsible for running the program.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.3
 */
public class Main {
/**
 * Method responsible for creating and showing GUI.
 */
    private static void createAndShowGUI() {        
        // JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("Arabic-Roman Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        View newContentPane = new View();
        frame.setContentPane(newContentPane);
        frame.setIconImage(newContentPane.getAppIcon().getImage());

        frame.setJMenuBar(new MenuBar());
        frame.pack();
        frame.setVisible(true);
    }
	
/**
 * Main method, responsible for running the program.
 * @param args the command line arguments -> not used
*/
    public static void main(String[] args) {
        try {
            setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        javax.swing.SwingUtilities.invokeLater(Main::createAndShowGUI);
    }
}
