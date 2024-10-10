package school.faang.BJS2_33441_HandlingErrorsBeautifully;

import com.sun.jdi.ObjectCollectedException;

import java.util.Objects;

public class ErrorHandler {
    public static <T> T withErrorHandling(ThrowableAction<T> action, ExceptionHandler<T> exceptionHandler) {
        if (action == null || exceptionHandler == null) {
            throw new IllegalArgumentException("Action and exception handler can't be null!");
        }
        try {
            return action.get();
        } catch (Exception exception) {
            return exceptionHandler.handle(exception);
        }
    }
}
