package school.faang.lambdas.exceptions;

public class IllegalMessageException extends IllegalArgumentException {

    public IllegalMessageException(String message) {
        super(message);
    }
}