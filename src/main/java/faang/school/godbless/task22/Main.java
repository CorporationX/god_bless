package faang.school.godbless.task22;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    private static RemoteService remoteService;

    public static void main(String[] args) {
        Supplier<String> action = () -> {
            // Здесь должно быть что-то, что может выбросить исключение
            throw new RuntimeException("Произошла ошибка");
        };

        ExceptionHandler errorHandler = e -> {
            System.out.println("Обработка ошибки: " + e.getMessage());
        };

        String result = withErrorHandling(action, errorHandler).orElseThrow(()->new RuntimeException("Запрос не вернул результатов"));
        System.out.println("Результат: " + result);
    }

    public static <T> Optional<T> withErrorHandling(Supplier<T> consumer, ExceptionHandler errorHandling) {
        try {
            return Optional.ofNullable(consumer.get());
        } catch (Exception e) {
            errorHandling.handle(e);
            return Optional.empty();
        }
    }

    public static String remoteService(String param) {
        try {
            return remoteService.call(param);
        } catch (Exception e) {
            return "DEFAULT";
        }
    }
}
