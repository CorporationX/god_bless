package faang.school.godbless.lambda.errors;

import java.util.function.Function;

public class ErrorHandler {
    private ErrorHandler() {
    }

    public static <T> T withErrorHandling(ThrowableSupplier<T> action, Function<Exception, T> exceptionAction) {
        try {
            return action.get();
        } catch (Exception e) {
            return exceptionAction.apply(e);
        }
    }

}
