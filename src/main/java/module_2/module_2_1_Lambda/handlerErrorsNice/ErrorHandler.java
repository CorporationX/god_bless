package module_2.module_2_1_Lambda.handlerErrorsNice;

import java.util.function.Function;

public class ErrorHandler {
    public static  <T> T withErrorHandling(ExceptionHandler<T> exception, Function<Exception,T> function) {
        try {
            return exception.get();
        } catch (Exception e) {
            return function.apply(e);
        }
    }
}
