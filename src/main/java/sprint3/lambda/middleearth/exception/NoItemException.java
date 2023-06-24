package sprint3.lambda.middleearth.exception;

public class NoItemException extends RuntimeException {
    public NoItemException() {
    }

    public NoItemException(String message) {
        super(message);
    }
}
