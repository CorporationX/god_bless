package faang.school.godbless.ProcessErrors;

import java.util.function.Supplier;

public class Processor {
    public static <T> T withErrorHandling(Supplier<T> function, ExceptionHandler<T> handler) {
        try {
            return function.get();
        } catch (Exception e) {
            System.out.println("Не удалось получить доступ к Remote Service");
            return handler.handle(e);
        }
    }
}
