package school.faang.Lambda.BJS2_33422;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        String result = withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса: " + e.getMessage());
                    return "DEFAULT";
                }
        );
        System.out.println("Результат: " + result);
    }

    public static <T> T withErrorHandling(ThrowingSupplier<T> action, Function<Exception, T> errorHandler) {
        if (action == null || errorHandler == null) {
            throw new IllegalArgumentException("Action и errorHandler не могут быть null");
        }
        try {
            return action.get();
        } catch (Exception e) {
            return errorHandler.apply(e);
        }
    }
}
