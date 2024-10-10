package ErrorsHandler;

import java.util.function.Function;

public class ErrorHandler<T> {
    public static <T> T withErrorHandling(ActionWithException<T> action, Function<Exception, T> handler ) {
        try {
            return action.execute();
        } catch (Exception e) {
            return handler.apply(e);
        }
    }
}
