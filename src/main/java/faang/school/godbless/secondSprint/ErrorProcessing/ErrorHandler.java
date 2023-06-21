package faang.school.godbless.secondSprint.ErrorProcessing;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> onError) {
        try {
            return action.get();
        } catch (Exception e) {
            return onError.handle(e);
        }
    }

    public interface ExceptionHandler<T> {
        T handle(Exception e);
    }
}
