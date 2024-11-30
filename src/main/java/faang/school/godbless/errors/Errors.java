package faang.school.godbless.errors;

import java.util.function.Supplier;

public class Errors {
    public static  <T> T withErrorHandling (Supplier<T> action, ExceptionHandler<T> onError) {
        try {
            return action.get();
        }
        catch (Exception e) {
            return onError.handle(e);
        }
    }
}
