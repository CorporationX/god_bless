package school.faang.task_46217;

import java.util.function.Function;

@FunctionalInterface
public interface Action<T> {
    T execute() throws Exception;

    static <T> T withErrorHandling(Action<T> mainFunction, Function<Exception, T> handlingFunction) {
        try {
            return mainFunction.execute();
        } catch (Exception e) {
            return handlingFunction.apply(e);
        }
    }
}
