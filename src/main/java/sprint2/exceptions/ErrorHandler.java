package sprint2.exceptions;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(throwableSupplier<T> action, Function<Exception, T> errorHandler) {
        try {
            return action.get();  // Выполняем основное действие
        } catch (Exception e) {
            return errorHandler.apply(e);  // Обрабатываем ошибку
        }
    }
}
