package school.faang.error_hending;

import java.util.function.Consumer;
import java.util.function.Function;

public class ErrorHandler {

    public static <T> T withErrorHandling(String name, Consumer<Exception> consumer, Function<String, T> function) {
        try {
            return function.apply(name);
        } catch (Exception e) {
            consumer.accept(e);
            return (T) "Перезапустите приложение";
        }
    }
}
