package pl.polsl.mj.model;

import java.util.Date;

/**
 * Main class, responsible for running the program.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.1
 */
public class ConversionData {
    /**
     * Conversion type.
     */
    private String conversionType;
    /**
     * Input.
     */
    private String input;
    /**
     * Output/result.
     */
    private String result;
    /**
     * Date of conversion.
     */
    private Date date;

    /**
     * Constructor of the ConversionData class.
     *
     * @param conversionType conversion type
     * @param input          input
     * @param result         output/result
     * @param date           date of conversion
     */
    public ConversionData(String conversionType, String input, String result, Date date) {
        this.conversionType = conversionType;
        this.input = input;
        this.result = result;
        this.date = date;
    }

    /**
     * Getter for conversion type.
     *
     * @return conversion type
     */
    public String getConversionType() {
        return conversionType;
    }

    /**
     * Setter for conversion type.
     *
     * @param conversionType conversion type
     */
    public void setConversionType(String conversionType) {
        this.conversionType = conversionType;
    }

    /**
     * Getter for input.
     *
     * @return input
     */
    public String getInput() {
        return input;
    }

    /**
     * Setter for input.
     *
     * @param input input
     */
    public void setInput(String input) {
        this.input = input;
    }

    /**
     * Getter for result.
     *
     * @return result
     */
    public String getResult() {
        return result;
    }

    /**
     * Setter for result.
     *
     * @param result result
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * Getter for date.
     *
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter for date.
     *
     * @param date date
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
