package school.faang.moduleone.sprinttwo.task_46240;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> fineCaseAction, Function<Exception, T> errorCaseAction) {
        try {
            return fineCaseAction.get();
        } catch (Exception e) {
            return errorCaseAction.apply(e);
        }
    }
}
