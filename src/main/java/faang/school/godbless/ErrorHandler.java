package faang.school.godbless;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> exceptionHandler){
        try{
            return action.get();
        } catch (Exception e){
            return exceptionHandler.handleException(e);
        }
    }
}
