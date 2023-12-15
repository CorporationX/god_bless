package faang.school.godbless.mistakes;

import java.util.function.Supplier;

public class Mistake {
    public <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> onError) {
        try {
            return action.get();
        } catch (Exception e) {
            return onError.handle(e);
        }
    }
}
