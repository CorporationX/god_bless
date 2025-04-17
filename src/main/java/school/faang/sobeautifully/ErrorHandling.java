package school.faang.sobeautifully;

import java.util.function.Supplier;

public class ErrorHandling {
    public static <T> T withErrorHandling(Supplier<T> supplierService, Handler<T> handler) {
        try {
            return supplierService.get();
        } catch (Exception e) {
            return handler.handler(e);
        }
    }
}
