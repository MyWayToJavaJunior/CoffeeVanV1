package kz.e16traning.coffeevan.exception;

/**
 * Load properties from file error.
 *
 */
public class LoadPriceFromFileException extends Exception{
    public LoadPriceFromFileException() {
        super("Cant load price from file");
    }
}
