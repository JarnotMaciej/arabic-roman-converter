package pl.polsl.mj.view;

import javax.swing.*;
import java.awt.*;

/**
 * Menu bar class, responsible for creating menu bar.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.3
 */
public class MenuBar extends JMenuBar {

    /**
     * Constructor of the MenuBar class.
     */
    public MenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu aboutMenu = new JMenu("About");
        JMenuItem aboutItem = new JMenuItem("About The program");
        aboutMenu.add(aboutItem);

        menuBar.add(aboutMenu);

        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(null, "Arabic-Roman Converter\n\nAuthor: Maciej Jarnot\nVersion: 1.3", "About", JOptionPane.INFORMATION_MESSAGE));
        menuBar.setVisible(true);
        menuBar.setPreferredSize(new Dimension(400, 20));
        add(menuBar);
    }
}
