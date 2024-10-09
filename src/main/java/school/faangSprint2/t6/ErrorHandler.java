package school.faangSprint2.t6;

public class ErrorHandler {

    @FunctionalInterface
    public interface ExceptionHandler<T> {
        T handle(Exception e);
    }

    @FunctionalInterface
    public interface CheckedExceptionSupplier<T> {
        T get() throws Exception;
    }

    public static <T> T withErrorHandling(CheckedExceptionSupplier<T> action, ExceptionHandler<T> errorHandler) {
        try {
            return action.get();  // Выполняем основное действие
        } catch (Exception e) {
            return errorHandler.handle(e);  // Обрабатываем ошибку
        }
    }
}