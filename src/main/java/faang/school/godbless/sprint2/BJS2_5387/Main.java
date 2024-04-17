package faang.school.godbless.sprint2.BJS2_5387;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        String result = withErrorHandling(
                () -> {
                    if (Math.random() > 0.5) {
                        throw new RuntimeException("Ошибка соединения");
                    }
                    return "Успешный вызов сервиса";
                },
                exception -> {
                    System.out.println("Не удалось получить доступ к Remote Service. Вернем default значение");
                    System.out.println(exception.toString());
                    return "DEFAULT";
                }
        );

        System.out.println("Результат: " + result);
    }

    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception exception) {
            return exceptionHandler.handle(exception);
        }
    }
}
