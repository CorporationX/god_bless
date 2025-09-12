package school.faang.bjs2_87575;

import java.util.function.Supplier;

public class ExceptionHandlerManager {
    private ExceptionHandlerManager() {
    }

    public static <T> T withErrorHandling(Supplier<T> caller, ExceptionHandler<T> handler) {
        try {
            return caller.get();
        } catch (Exception e) {
            return handler.handle(e);
        }
    }
}
