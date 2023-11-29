package pl.polsl.mj.model;

/**
 * Custom exception class for model.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.4
 */
public class ModelException extends Exception {

    /**
     * Constructor for ModelException class.
     *
     * @param message message to be displayed
     */
    public ModelException(String message) {
        super(message);
    }
}
