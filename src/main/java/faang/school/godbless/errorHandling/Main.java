package faang.school.godbless.errorHandling;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        String accessed = withErrorHandling(() -> RemoteService.call(true), Throwable::getMessage);
        String denied = withErrorHandling(() -> RemoteService.call(false), Throwable::getMessage);
        System.out.println(accessed);
        System.out.println(denied);
    }

    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> handler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            System.out.println("Не удалось получить доступ к Remote Service. Вернем default значение");
            return handler.handleException(e);
        }
    }
}
