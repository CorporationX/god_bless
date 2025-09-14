package school.faang.lambda.bjs2_87603;

import java.util.function.Supplier;

public class ErrorHandler {

    public static <T> T withErrorHandling(Supplier<T> supplier, Handler<T> handler) {
        T result = null;
        try {
            result = supplier.get();
        } catch (Exception e) {
            result = handler.handle(e);
        }
        return result;
    }
}