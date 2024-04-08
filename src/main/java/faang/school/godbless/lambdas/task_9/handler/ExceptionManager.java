package faang.school.godbless.lambdas.task_9.handler;

import java.util.function.Supplier;

public class ExceptionManager<T> {
    public T manageMethodWithException(Supplier<T> action, ExceptionHandler<T> exceptionHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }
}