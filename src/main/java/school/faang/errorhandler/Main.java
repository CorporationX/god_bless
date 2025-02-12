package school.faang.errorhandler;

public class Main {
    private static final String DEFAULT_VALUE = "Default value";

    public static void main(String[] args) {
        String errorResult = ErrorHandler.withErrorHandling(
                () -> RemoteService.errorCall("someParam"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return DEFAULT_VALUE;
                }
        );

        System.out.printf("Результат при оишбке: %s%n", errorResult);

        String successResult = ErrorHandler.withErrorHandling(
                () -> RemoteService.successCall("someParam"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return DEFAULT_VALUE;
                }
        );

        System.out.printf("Успешный результат: %s%n", successResult);
    }

    public static class RemoteService {
        public static String errorCall(String param) {
            throw new RuntimeException("Сервис недоступен");
        }

        public static String successCall(String param) {
            return "RESPONSE";
        }
    }
}
