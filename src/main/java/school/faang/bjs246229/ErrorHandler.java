package school.faang.bjs246229;

import java.util.concurrent.Callable;

public class ErrorHandler {
    public static <T> T withErrorHandling(Callable<T> callable, Handler<T> handler) {
        try {
            return callable.call();
        } catch (Exception e) {
            return handler.handler(e);
        }
    }
}
