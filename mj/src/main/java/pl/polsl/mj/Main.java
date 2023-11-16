package pl.polsl.mj;

import javax.swing.*;

import pl.polsl.mj.view.*;

import static javax.swing.UIManager.*;

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

        JFrame frame = new JFrame("Arabic-Roman Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        View newContentPane = new View();
        frame.setContentPane(newContentPane);
        frame.setIconImage(newContentPane.getAppIcon().getImage());

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
//            setLookAndFeel(getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

// TODO:
//- GUI application based on Swing, including:
//        - [x] an advanced container (tabbed pane, split pane),
//        - [x] message box (JOptionPane for Swing) to indicate validation errors or information messages,
//        - [ ] table to store the history of performed operations,
//        - [ ] menu
