package faang.school.godbless.sprint2.Handle_errors;

import java.util.function.Supplier;

public class HandleErrors {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> errorHandling) {
        try {
            return action.get();
        } catch (Exception e) {
            return errorHandling.exception(e);
        }
    }
}
