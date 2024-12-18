package faang.school.godbless.sprint_2.task_46273;

public class ErrorHandler {

    public static <T, E extends Exception> T withErrorHandling(ThrowableSupplier<T, E> mainAction,
                                                               ExceptionHandler<T> exceptionAction) {
        try {
            return mainAction.get();
        } catch (Exception e) {
            return exceptionAction.handle(e);
        }
    }
}
