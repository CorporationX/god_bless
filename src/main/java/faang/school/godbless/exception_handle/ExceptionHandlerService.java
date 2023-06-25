package faang.school.godbless.exception_handle;

import java.util.function.Supplier;

public class ExceptionHandlerService {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> onError) {
        try {
            return action.get();
        } catch (Exception e) {
            return onError.handle(e);
        }
    }
}
