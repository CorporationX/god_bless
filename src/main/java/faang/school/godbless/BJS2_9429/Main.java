package faang.school.godbless.BJS2_9429;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Supplier<String> supplier = () -> {
            System.out.println("Пытаемся подключиться к серверу");
            if (Math.random() > 0.5) {
                throw new RuntimeException("Внезапная ошибка");
            } else return "УСПЕШНОЕ ПОДКЛЮЧЕНИЕ";
        };

        ExceptionHandler<String> exceptionHandler = exception -> {
            System.out.println("Не удалось получить доступ к Remote Service. Вернем default значение");
            return "DEFAULT";
        };

        String result = withErrorHandling(supplier, exceptionHandler);
        System.out.println(result);
    }

    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }
}
