package school.faang.task_46166;

public class ErrorHandler {
    public static <T, P> T withErrorHandling(ThrowableFunction<P, T, Exception> functionCall,
                                             P callParam, ExceptionHandler<T> errorHandler) {
        try {
            return functionCall.apply(callParam);
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }

}
