package school.faang_sprint_2.handle_errors_beautifully;

import java.util.function.Function;
import java.util.function.Supplier;

public interface ErrorHandler {

    static <T> T withErrorHandling(Supplier<T> supplier, Function<Exception, T> errorHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return errorHandler.apply(e);
        }
    }
}
