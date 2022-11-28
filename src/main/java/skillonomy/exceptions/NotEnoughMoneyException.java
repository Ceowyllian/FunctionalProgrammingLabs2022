package skillonomy.exceptions;

public class NotEnoughMoneyException extends Exception {

    public final double lacks;

    public NotEnoughMoneyException(double required, double provided, String message) {
        super(message);
        if (required <= provided) throw new IllegalArgumentException();
        lacks = required - provided;
    }
}
