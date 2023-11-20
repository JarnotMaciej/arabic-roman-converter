package pl.polsl.mj.model;

import java.util.Date;

/**
 * ConversionData class, responsible for storing conversion data.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.3
 */
public class ConversionData {
    /**
     * Conversion type.
     */
    private final String conversionType;
    /**
     * Input.
     */
    private final String input;
    /**
     * Output/result.
     */
    private final String result;
    /**
     * Date of conversion.
     */
    private final Date date;

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
     * Getter for input.
     *
     * @return input
     */
    public String getInput() {
        return input;
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
     * Getter for date.
     *
     * @return date
     */
    public Date getDate() {
        return date;
    }

}
