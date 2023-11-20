package pl.polsl.mj.view;

import pl.polsl.mj.model.ConversionData;
import pl.polsl.mj.model.Model;
import pl.polsl.mj.model.ModelException;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * View class, responsible for displaying GUI to the user.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.3
 */
public class View extends JPanel implements ActionListener {
    /**
     * Model object.
     */
    Model model = new Model();

    /**
     * Conversion table.
     */
    JTable table = new JTable(new MyTableModel());

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
        ImageIcon arabic = createImageIcon("/icons/arabic.png");
        ImageIcon roman = createImageIcon("/icons/roman.png");
        ImageIcon history = createImageIcon("/icons/history.png");
        appIcon = createImageIcon("/icons/app.png");

        JComponent arabicPanel = makeArabicPanel();
        tabbedPane.addTab("Arabic", arabic, arabicPanel,
                "Arabic to Roman");
        tabbedPane.setMnemonicAt(0, 1);

        JComponent romanPanel = makeRomanPanel();
        tabbedPane.addTab("Roman", roman, romanPanel,
                "Roman to Arabic");
        tabbedPane.setMnemonicAt(1, 2);

        JComponent historyPanel = makeHistoryPanel();
        tabbedPane.addTab("History", history, historyPanel,
                "History of conversions");
        tabbedPane.setMnemonicAt(2, 3);

        add(tabbedPane);
    }

    /**
     * Method responsible for creating panel with history of conversions - array of strings.
     * @return JComponent object with history of conversions
     */
    private JComponent makeHistoryPanel() {
        JPanel panel = new JPanel(false);
        table.setPreferredScrollableViewportSize(new Dimension(400, 200));
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        panel.setPreferredSize(new Dimension(400, 200));
        ((MyTableModel) table.getModel()).update();
        return panel;
    }

    /**
     * Method responsible for creating panel with Roman to Arabic converter.
     * @return JComponent object with Roman to Arabic converter
     */
    private JComponent makeRomanPanel() {
        JPanel panel = new JPanel(false);
        JLabel label = new JLabel("Enter Roman numeral:");
        label.setHorizontalAlignment(JLabel.LEFT);
        JTextField textField = new JTextField(10);
        JButton button = new JButton("Convert");
        button.addActionListener(e -> {
            String input = textField.getText();

            if (model.validateRoman(input)) {
                try {
                    int arabicNumber = model.romanToArabic(input);

                    JOptionPane.showMessageDialog(null, "Arabic number: " + arabicNumber, "Conversion Result", JOptionPane.INFORMATION_MESSAGE);
                    ((MyTableModel) table.getModel()).update();
                } catch (ModelException ex) {
                    JOptionPane.showMessageDialog(null, "Program accepts only valid roman numerals", "Invalid Roman numeral!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Program accepts only valid roman numerals", "Invalid Roman numeral!", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(label);
        panel.add(textField);
        panel.add(button);
        panel.setPreferredSize(new Dimension(400, 200));
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
        button.addActionListener(e -> {
            String input = textField.getText();

            if (model.validateArabic(input)) {
                try {
                    int arabicNumber = Integer.parseInt(input);

                    String romanNumeral = model.arabicToRoman(arabicNumber);

                    JOptionPane.showMessageDialog(null, "Roman Numeral: " + romanNumeral, "Conversion Result", JOptionPane.INFORMATION_MESSAGE);
                    ((MyTableModel) table.getModel()).update();

                } catch (NumberFormatException | ModelException ex) {
                JOptionPane.showMessageDialog(null, "Program accepts only valid arabic numbers (from 1 to 3999)", "Invalid Arabic number!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Program accepts only valid arabic numbers (from 1 to 3999)", "Invalid Arabic number!", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(label);
        panel.add(textField);
        panel.add(button);
        panel.setPreferredSize(new Dimension(400, 200));
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
            Image newImg = image.getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING);
            icon = new ImageIcon(newImg);

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
        //
    }

    /**
     * Private class for table model.
     */
    private class MyTableModel extends AbstractTableModel {
        /**
         * Array of strings with column names.
         */
        private final String[] columnNames = {"Conversion type", "Input", "Result", "Date"};

        /**
         * Array of strings with data.
         */
        private List<ConversionData> data = new ArrayList<>();

        /**
         * Method used for updating values from model.
         */
        public void update() {
            fireTableDataChanged();
            data = model.getHistory();
        }

        /**
         * Getter for row count.
         * @return row count
         */
        @Override
        public int getRowCount() {
            try {
                return data.size();
            } catch (NullPointerException e) {
                return 0;
            }
        }

        /**
         * Getter for column count.
         * @return column count
         */
        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        /**
         * Method for getting column content.
         * @param rowIndex the row whose value is to be queried
         * @param columnIndex the column whose value is to be queried
         * @return the value Object at the specified cell
         */
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            ConversionData conversionData = data.get(rowIndex);

            return switch (columnIndex) {
                case 0 -> conversionData.getConversionType();
                case 1 -> conversionData.getInput();
                case 2 -> conversionData.getResult();
                case 3 -> {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                    yield dateFormat.format(conversionData.getDate());
                }
                default -> null;
            };
        }

        /**
         * Method for getting column name.
         * @param columnIndex the column whose value is to be queried
         * @return the name of columnName
         */
        @Override
        public String getColumnName(int columnIndex) {
            return columnNames[columnIndex];
        }
    }
}
