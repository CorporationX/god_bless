package school.faang.moduleone.sprinttwo.task_46240;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> fineCaseAction, Function<Exception, T> errorCaseAction) {
        T result;
        try {
            result = fineCaseAction.get();
        } catch (Exception e) {
            result = errorCaseAction.apply(e);
        }
        return result;
    }
}
