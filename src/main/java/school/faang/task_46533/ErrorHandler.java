package school.faang.task_46533;

import java.util.function.Function;

public class ErrorHandler {
    public static <T> T withErrorHandling(Action<T> mainAction, Function<Exception, T> errorHandler) {
        try {
            return mainAction.act();
        } catch (Exception error) {
            return errorHandler.apply(error);
        }
    }
}
