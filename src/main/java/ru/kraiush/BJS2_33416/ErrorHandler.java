package ru.kraiush.BJS2_33416;

import java.util.function.Function;

public class ErrorHandler {

    public static <T> T withErrorHandling(Handler<T> generalAction, Function<Exception, T> handler) {
        try {
            return generalAction.handle();
        } catch (Exception e) {
            return handler.apply(e);
        }
    }
}
