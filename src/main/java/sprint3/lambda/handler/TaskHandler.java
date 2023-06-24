package sprint3.lambda.handler;

import java.util.function.Supplier;

public class TaskHandler {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> handler) {
        try {
            return action.get();
        } catch (Exception e) {
            return handler.handle(e);
        }
    }
}
