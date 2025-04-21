package school.faang.bjs270272;

import java.util.function.Supplier;

public class ErrorUtil {
    public static <T> T withErrorHandling(Supplier<T> action, ErrorHandler<T> errorHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}
