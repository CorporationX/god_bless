package faang.school.godbless.metaExceptions;

import java.util.function.Supplier;

public class Main {

    private static final HandlerService<String> HANDLER_SERVICE = new HandlerService<>();
    private static final ExceptionHandler<String> EXCEPTION_HANDLER = e -> {
        System.out.println("Не удалось получить доступ к Remote Service. Вернем default значение");
        return "Default";
    };

    public static void main(String[] args) {
        Supplier<String> okHandler = () -> "OK";

        String res = HANDLER_SERVICE.withErrorHandling(okHandler, EXCEPTION_HANDLER);
        System.out.println(res);

        Supplier<String> errorHandler = () -> {
            throw new IllegalArgumentException("MK");
        };
        res = HANDLER_SERVICE.withErrorHandling(errorHandler, EXCEPTION_HANDLER);
        System.out.println(res);
    }
}
