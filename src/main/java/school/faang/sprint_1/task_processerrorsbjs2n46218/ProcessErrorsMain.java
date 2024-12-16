package school.faang.sprint_1.task_processerrorsbjs2n46218;

import java.util.function.Function;
import java.util.function.Supplier;

public class ProcessErrorsMain {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandlingProto(
                () -> RemoteService.call("someParam"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );
        System.out.println(result);
    }

    public static class ErrorHandler {
        // Мой эксперимент, тоже работает - с применеием стандартных интерфейсов.
        public static <R> R withErrorHandlingProto(Supplier<R> supplierAction, Function<Exception, R> function) {
            try {
                return supplierAction.get();
            } catch (Exception e) {
                return function.apply(e);
            }
        }

        public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> errorHandler) {
            try {
                return action.get();
            } catch (Exception e) {
                return errorHandler.handle(e);
            }
        }
    }

    public static class RemoteService {
        public static String call(String param) {
            throw new RuntimeException();
        }
    }
}

