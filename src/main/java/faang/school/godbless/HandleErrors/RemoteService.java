package faang.school.godbless.HandleErrors;

import java.util.function.Supplier;

public class RemoteService {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> handler) {
        try {
            return action.get();
        } catch (Exception e) {
            return handler.handle(e);
        }
    }
}
