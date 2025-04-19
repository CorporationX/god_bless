package school.faang.bjs2_71688;

import java.util.function.Function;

public class ErrorHandler {
    public static <T extends Object> T withErrorHandling(Runnable runnable, Function<Exception, T> function) {
        try {
            runnable.run();
        } catch (Exception e) {
            return function.apply(e);
        }
        return (T) null;
    }
}
