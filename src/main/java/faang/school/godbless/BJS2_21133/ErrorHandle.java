package faang.school.godbless.BJS2_21133;

import java.util.function.Supplier;

public class ErrorHandle {

    static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> onError) {
        try {
            return action.get();
        } catch (Exception e) {
            return onError.handle(e);
        }
    }
}
