package school.faang.Sprint2.exeptions;

import java.util.function.Function;

public class ErrorHandler {
    public static <T> T withErrorHandling(throwableSupplier<T> action, Function<Exception, T> errorHandler) {
        try {
            return action.get();  // Выполняем основное действие
        } catch (Exception e) {
            return errorHandler.apply(e);  // Обрабатываем ошибку
        }
    }
}
