package school.faang.task_46217;

import java.util.function.Function;
import java.util.function.Supplier;

@FunctionalInterface
public interface Action<T> {
    T execute() throws Exception;

    static <T> T withErrorHandling(Supplier<T> mainFunction, Function<Exception, T> handlingFunction) {
        try {
            return mainFunction.get();
        } catch (Exception e) {
            return handlingFunction.apply(e);
        }
    }
}
