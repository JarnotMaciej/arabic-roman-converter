package pl.polsl.mj.view;

import pl.polsl.mj.model.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.*;

/**
 * View class, responsible for displaying GUI to the user.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.1
 */
public class View extends JPanel implements ActionListener {
    /**
     * Model object.
     */
    Model model = new Model();

    /**
     * App icon.
     */
    ImageIcon appIcon;

    /**
     * Getter for app icon.
     * @return app icon
     */
    public ImageIcon getAppIcon() {
        return appIcon;
    }

    /**
     * Constructor of the View class.
     */
    public View() {
        super(new GridLayout(1, 1));
        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon arabic = createImageIcon("/images/arabic.png");
        ImageIcon roman = createImageIcon("/images/roman.png");
        appIcon = createImageIcon("/images/app.png");

        JComponent arabicPanel = makeArabicPanel();
        tabbedPane.addTab("Arabic", arabic, arabicPanel,
                "Arabic to Roman");
        tabbedPane.setMnemonicAt(0, 1);

        JComponent romanPanel = makeRomanPanel();
        tabbedPane.addTab("Roman", roman, romanPanel,
                "Roman to Arabic");
        tabbedPane.setMnemonicAt(1, 2);

        add(tabbedPane);
    }

    /**
     * Method responsible for creating panel with Roman to Arabic converter.
     * @return JComponent object with Roman to Arabic converter
     */
    private JComponent makeRomanPanel() {
        JPanel panel = new JPanel(false);
        JLabel label = new JLabel("Enter Roman numeral:");
        JTextField textField = new JTextField(10);
        JButton button = new JButton("Convert");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();

                // Validate the input as Roman numeral
                if (model.validateRoman(input)) {
                    try {
                        // Convert Roman to Arabic using the model method
                        int arabicNumber = model.romanToArabic(input);

                        // Display the result or perform any desired action
                        JOptionPane.showMessageDialog(null, "Arabic number: " + arabicNumber, "Conversion Result", JOptionPane.INFORMATION_MESSAGE);
                    } catch (ModelException ex) {
                        // Handle exception, e.g., invalid input
                        JOptionPane.showMessageDialog(null, "Invalid Roman numeral", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // Handle invalid input
                    JOptionPane.showMessageDialog(null, "Invalid Roman numeral", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(label);
        panel.add(textField);
        panel.add(button);
        return panel;
    }

    /**
     * Method responsible for creating panel with Arabic to Roman converter.
     * @return JComponent object with Arabic to Roman converter
     */
    private JComponent makeArabicPanel() {
        JPanel panel = new JPanel(false);
        JLabel label = new JLabel("Enter Arabic number:");
        JTextField textField = new JTextField(10);
        JButton button = new JButton("Convert");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();

                // Validate the input as Arabic number
                if (model.validateArabic(input)) {
                    try {
                        int arabicNumber = Integer.parseInt(input);

                        // Convert Arabic to Roman using the model method
                        String romanNumeral = model.arabicToRoman(arabicNumber);

                        // Display the result or perform any desired action
                        JOptionPane.showMessageDialog(null, "Roman Numeral: " + romanNumeral, "Conversion Result", JOptionPane.INFORMATION_MESSAGE);
                    } catch (NumberFormatException | ModelException ex) {
                        // Handle exception, e.g., invalid input
                        JOptionPane.showMessageDialog(null, "Invalid Arabic number", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // Handle invalid input
                    JOptionPane.showMessageDialog(null, "Invalid Arabic number", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(label);
        panel.add(textField);
        panel.add(button);
        return panel;
    }

    /**
     * Method responsible for loading image from file.
     * @param path path to the image
     * @return ImageIcon object
     */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = View.class.getResource(path);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            Image image = icon.getImage();
            Image newimg = image.getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING);
            icon = new ImageIcon(newimg);

            return icon;
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }


    /**
     * Overriding actionPerformed method from ActionListener interface.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button click event
        // TODO: implementation
    }

    /**
     * Getting input from user
     *
     * @return input from user
     */
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
