package school.faang.task_46158;

public class Main {
    public static void main(String[] args) {
        ExceptionHandler<String> exceptionHandler = e -> {
            System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
            return "DEFAULT";
        };

        // Пример с вызовом удалённого сервиса
        String errorResult = ErrorHandler.withErrorHandling(
                () -> RemoteService.callWithException("someParam"),  // Основное действие
                exceptionHandler
        );

        System.out.println(errorResult);

        String successResult = ErrorHandler.withErrorHandling(
                () -> RemoteService.callSuccess("Ho-ho-ho"),
                exceptionHandler
        );

        System.out.println(successResult);
    }

    // Пример метода для удалённого сервиса
    public static class RemoteService {
        public static String callWithException(String param) throws Exception {
            // Здесь возникнет ошибка для демонстрации
            throw new Exception("Сервис недоступен");
        }

        public static String callSuccess(String param) {
            return "Call success with param = " + param;
        }
    }
}
