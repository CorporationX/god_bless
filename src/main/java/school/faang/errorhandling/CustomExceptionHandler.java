package school.faang.errorhandling;

public class CustomExceptionHandler extends RuntimeException {
    public CustomExceptionHandler(String message) {
        super(message);
    }
}
