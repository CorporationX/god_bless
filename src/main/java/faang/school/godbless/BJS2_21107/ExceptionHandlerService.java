package faang.school.godbless.BJS2_21107;

import java.util.function.Supplier;

public class ExceptionHandlerService {

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> onError) {
        try {
            return action.get();
        } catch (Exception e) {
            return onError.handle(e);
        }
    }
}