package school.faang.bjs2_70663.meta_universe.exception;

public class HandlerNotFoundException extends RuntimeException {
    public HandlerNotFoundException(String message, Object... args) {
        super(ExceptionMessageFormatter.format(message, args));
    }
}
