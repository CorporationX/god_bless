package ru.kraiush.BJS2_33416;

public class ErrorHandler {

    public static <T> T withErrorHandling(ThrowingSupplier<T> action, Handler<T> handler) {
        try {
            return action.get();
        } catch (Exception e) {
            return handler.handle(e);
        }
    }
}
