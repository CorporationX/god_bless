package school.faang.sprint_2.task_43530;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> errorHandler) {
        try {
            return action.get();  // Выполняем основное действие
        } catch (Exception e) {
            return errorHandler.handle(e);  // Обрабатываем ошибку
        }
    }
}
