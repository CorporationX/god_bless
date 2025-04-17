package school.faang.bjs270224;

import java.util.function.Supplier;

public class ErrorHandler {

    public static <T> T withErrorHandling(Supplier<T> supplier,
                                          ErrorHandlerFunctionInterface.ErrorHandlerFunction<T> handler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return handler.handle(e);
        }
    }
}
