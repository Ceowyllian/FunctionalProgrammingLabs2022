package skillonomy.exceptions;

public class NotEnoughTokensException extends Exception {

    public final double lacks;

    public NotEnoughTokensException(double required, double provided, String message) {
        super(message);
        if (required <= provided) throw new IllegalArgumentException();
        lacks = required - provided;
    }
}
