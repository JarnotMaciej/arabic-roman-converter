package pl.polsl.mj.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * ConversionData class, responsible for storing conversion data.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.4
 */
@Entity
public class ConversionData {
    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
     * Getter for id.
     *
     * @return id
     */
    public Long getId() {
        return id;
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

    // setters

    /**
     * Setter for id.
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for conversion type.
     *
     * @param conversionType conversion type
     */
    public void setConversionType(String conversionType) {
        this.conversionType = conversionType;
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
     * Setter for result.
     *
     * @param result result
     */
    public void setResult(String result) {
        this.result = result;
    }

}
