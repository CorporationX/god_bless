package school.faang.bjs2_33468;


import java.util.function.Function;

public class ErrorHandler {
    public static <T> T withErrorHandling(ExceptionHandler<T> handler, Function<Exception, T> function) {
        try {
            return handler.handle();
        } catch (Exception e) {
            return function.apply(e);
        }
    }
}
