package faang.school.godbless.handleErrorsGracefuly;

import java.util.concurrent.Callable;

public class ErrorHandling {
    public static <T> T withErrorHandling(Callable<T> doing, ExceptionHandler<T> exceptionHandler) {
        try {
            return doing.call();
        } catch (Exception e) {
            return exceptionHandler.doIfException(e);
        }
    }
}