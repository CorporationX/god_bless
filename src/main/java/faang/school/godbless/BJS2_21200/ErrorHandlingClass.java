package faang.school.godbless.BJS2_21200;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class ErrorHandlingClass {
    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> errorHandling) {
        try {
            return supplier.get();
        } catch (Exception e) {
            log.warn("Не удалось выполнить операцию. Применяется обработка исключения.", e);
            return errorHandling.handlingException(e);
        }
    }
}
