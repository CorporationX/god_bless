package faang.school.godbless.beautiful.exception.handling;

public class ExceptionHandler {

    static <T> T withErrorHandling(ThrowingSupplier<T> action, ExceptionHandlers<T> onError) {
        try {
            return action.get();
        } catch (Exception e) {
            return onError.handle(e);
        }
    }
}
