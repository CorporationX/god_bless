package school.faang.HandleErrors;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Callable<T> action, ExceptionHandler<T> errorHandler){
        try {
            return action.call();
        } catch (Exception e){
            return errorHandler.handle(e);
        }
    }
}
