package school.faang.bjs_46193;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {

    public static <T> T withErrorHandling(Supplier<T> action, Function<Exception, T> processor) {
        try {
            return action.get();
        } catch (Exception e) {
            return processor.apply(e);
        }
    }

}
