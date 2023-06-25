package faang.school.godbless.handleErrors;


import java.util.function.Supplier;

public class HandleErrors {
    public static <T> T withErrorHandling(Supplier<T> activity, Handler<T> exceptionHandler) {
        try {
            return activity.get();
        } catch (Exception e) {
            return exceptionHandler.exception(e);
        }
    }
}
