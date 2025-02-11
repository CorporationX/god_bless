package school.faang.sprint2.task_BJS2_57600;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> exceptionHandler) {
        checkAction(action);
        checkExceptionHandle(exceptionHandler);

        try {
            return action.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }

    private static  <T> void checkAction(Supplier<T> action) {
        if (action == null) {
            throw new IllegalArgumentException("Действие не может быть null");
        }
    }

    private static <T> void checkExceptionHandle(ExceptionHandler<T> exceptionHandler) {
        if (exceptionHandler == null) {
            throw new IllegalArgumentException("Обработчик не может быть null");
        }
    }
}
