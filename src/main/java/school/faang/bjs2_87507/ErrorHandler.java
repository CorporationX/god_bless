package school.faang.bjs2_87507;

import java.util.function.Supplier;

public class ErrorHandler {
    private ErrorHandler() {}

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> handler) {
        try {
            return action.get();
        } catch (Exception e) {
            return handler.handle(e);
        }
    }
}
