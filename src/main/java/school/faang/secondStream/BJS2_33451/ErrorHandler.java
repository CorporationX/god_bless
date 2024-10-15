package school.faang.secondStream.BJS2_33451;


public class ErrorHandler {
    static <T> T withErrorHandling(TryAction<T> action, ExceptionHandler<T> handler) {
        try {
            return action.action();
        } catch (Exception e) {
            return handler.handle(e);
        }
    }
}
