package faang.school.godbless.interfaces.expinterf;

import java.util.function.Supplier;

public class Main {

    static <T> T withErrorHandling(Supplier<T> act, ExceptionHandler<T> handler) {
        try {
            return act.get();
        } catch (Exception e) {
            return handler.handle(e);
        }
    }
}
