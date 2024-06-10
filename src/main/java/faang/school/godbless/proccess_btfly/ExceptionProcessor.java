package faang.school.godbless.proccess_btfly;

import java.util.function.Function;

public class ExceptionProcessor {
    public static <T, R> R process(T argument, Function<T,R> firstAction, ExceptionHandler<R> exceptionHandler) {
        try {
            return firstAction.apply(argument);
        } catch (Exception exception) {
            return exceptionHandler.processException(exception);
        }
    }
}
