package school.faang.sprint_2.task_46162;

public class ErrorHandler {
    public static <T> T withErrorHandling(ActionSupplier<T> action, ExceptionHandler<T> handler) {
        try {
            return action.get();
        } catch (Exception e) {
            return handler.handle(e);
        }
    }
}
