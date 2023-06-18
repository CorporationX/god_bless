package handle_exception_beautifully;

import java.util.function.Supplier;

public class ExceptionHandlingUtil {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> onError) {
        try {
            return action.get();
        } catch (Exception e) {
            return onError.handle(e);
        }
    }
}
