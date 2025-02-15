package BJS2_57569;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> handler) {
        try {
            log.info("Вызов метода");
            return supplier.get();
        } catch (Exception e) {
            log.error("Ошибка при вызове метода", e);
            return handler.handle(e);
        }
    }
}
