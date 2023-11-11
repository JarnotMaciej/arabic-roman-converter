package pl.polsl.mj.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * View class, responsible for displaying GUI to the user.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.1
 */
public class View extends JFrame implements ActionListener {

/**
 * Constructor of the View class.
 */
public View() {
        super("Arabic-Roman converter");

        JLabel label = new JLabel("Enter number to convert: ");
        JTextField textField = new JTextField();
        JRadioButton radioButton1 = new JRadioButton("Arabic to Roman");
        JRadioButton radioButton2 = new JRadioButton("Roman to Arabic");
        JButton confirmBtn = new JButton("Convert");
        JLabel resultLabel = new JLabel("Result will be displayed here");

        confirmBtn.setActionCommand("convert");
        radioButton1.setActionCommand("arabicToRoman");
        radioButton2.setActionCommand("romanToArabic");

        // listeners
        confirmBtn.addActionListener(this);
        radioButton1.addActionListener(this);
        radioButton2.addActionListener(this);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);

        setLayout(null);

        // Component placement
        label.setBounds(10, 10, 200, 30);
        textField.setBounds(10, 50, 200, 30);
        radioButton1.setBounds(10, 90, 150, 30);
        radioButton2.setBounds(10, 130, 150, 30);
        confirmBtn.setBounds(10, 170, 100, 30);
        resultLabel.setBounds(10, 210, 250, 30);

        // Add components to the frame
        add(label);
        add(textField);
        add(radioButton1);
        add(radioButton2);
        add(confirmBtn);
        add(resultLabel);

        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

/**
 * Overriding actionPerformed method from ActionListener interface.
 */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button click event
        // TODO: implementation
    }
}
