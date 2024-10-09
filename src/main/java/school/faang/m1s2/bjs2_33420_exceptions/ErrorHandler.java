package school.faang.m1s2.bjs2_33420_exceptions;

import java.util.function.Function;

public class ErrorHandler {

    public static <T> T withErrorHandling(SelfMadeCallable<T> checker, Function<Exception, T> handler) {
        try {
            return checker.check();
        } catch (Exception e) {
            return handler.apply(e);
        }
    }
}
