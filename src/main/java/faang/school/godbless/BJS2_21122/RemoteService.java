package faang.school.godbless.BJS2_21122;

import java.util.function.Function;

public class RemoteService {
    public static <T> T withErrorHandling(T param, Function<T, T>  call, ExceptionHandler<T> exceptionHandler) {
        try {
            return call.apply(param);
        } catch (Exception exception) {
            return exceptionHandler.handle(exception);
        }
    }
}
