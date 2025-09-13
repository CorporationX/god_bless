package school.faang.bjs287537;

import java.util.function.Function;

public class ErrorHandler {
    public static <T> T withErrorHandling(Runnable action, Function<Throwable, T> errorHandler) {
        try {
            action.run();
            return (T) "Действие выполнено успешно";
        } catch (Throwable t) {
            return errorHandler.apply(t);
        }
    }
}
