package faang.school.godbless.task.lambda.handling.exceptions.beautifully;

import java.util.function.Supplier;

public class Main {
    private static SomeData someData = new SomeData();

    public static void main(String... args) {
        // Получить существующие данные
        String data = getData(2);
        System.out.println("Данные: " + data);

        // Попытаться получить не существующие данныые,
        // вызвать исключение и вернуть сообщение ошибки
        data = getData(4);
        System.out.println("Данные: " + data);
    }

    public static String getData(int id) {
        return withErrorHandling(() -> someData.getData(id), exception -> exception.getMessage());
    }

    public static <T> T withErrorHandling(Supplier<T> supplier,
                                          ExceptionHandler<T> exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception exception) {
            return exceptionHandler.handle(exception);
        }
    }
}
