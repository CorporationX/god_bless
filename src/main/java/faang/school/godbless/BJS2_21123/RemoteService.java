package faang.school.godbless.BJS2_21123;

import java.util.function.Function;

public class RemoteService {
    public static <T, U> U withErrorHandling(T param, Function<T, U> call, ExceptionHandler<U> exceptionHandler) {
        try {
            return call.apply(param);
        } catch (Exception exception) {
            return exceptionHandler.handle(exception);
        }
    }
}
