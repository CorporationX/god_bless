package school.faang.coolerrorhandling;


import java.util.function.Function;

public class ErrorHandler {

    public static <T> T withErrorHandling(ExceptionHandler<T> errorHandler, Function<Exception, T> handler) {
        try {
            return errorHandler.execute();
        } catch (Exception e) {
            return handler.apply(e);
        }
    }
}