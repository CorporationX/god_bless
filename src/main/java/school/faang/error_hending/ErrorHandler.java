package school.faang.error_hending;

import java.util.function.Consumer;
import java.util.function.Function;

public class ErrorHandler {
    public Object withErrorHandling(String name, Consumer<String> consumer, Function<String, Object> function) {
        try {
            return function.apply(name);
        } catch (RuntimeException e) {
            consumer.accept(String.valueOf(e));
            return "Default";
        }
    }
}
