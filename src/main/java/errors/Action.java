package errors;

import java.util.Objects;
import java.util.function.Consumer;

public class Action<T> {

    public Action<T> doAction(Consumer<T> consumer, ExceptionHandler exceptionHandler) {
        Action<T> action = new Action<>();
        String name = null;
        if (name != null) {
            consumer.accept((T) name);
        } else {
            Exception ex =  exceptionHandler.operation(new IllegalArgumentException());
            throw new IllegalArgumentException(ex);
        }
        return action;
    }
}
