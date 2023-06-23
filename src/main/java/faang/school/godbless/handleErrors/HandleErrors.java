package faang.school.godbless.handleErrors;

import ch.qos.logback.core.net.SocketConnector;

import java.util.function.Supplier;

public class HandleErrors {
    public static <T> T withErrorHandling(Supplier<T> activity, ExceptionHandler<T> exceptionHandler) {
        try {
            return activity.get();
        } catch (Exception e) {
            return exceptionHandler.exception(e);
        }
    }
}
