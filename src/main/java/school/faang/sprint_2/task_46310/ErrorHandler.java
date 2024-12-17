package school.faang.sprint_2.task_46310;

import java.util.function.Function;

public class ErrorHandler {
    public static <T> T withErrorHandling(Action<T> action, Function<Exception, T> errorHandler) {
        try {
            return action.execute();
        } catch (Exception e) {
            return errorHandler.apply(e);
        }
    }
}
