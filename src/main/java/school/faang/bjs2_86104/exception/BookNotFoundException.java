package school.faang.bjs2_86104.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException(String message, RuntimeException e) {
        super(message, e);
    }
}
