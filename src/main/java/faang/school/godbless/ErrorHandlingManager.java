package faang.school.godbless;

import java.util.function.Supplier;

public class ErrorHandlingManager {

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler exceptionHandler) {
        try{
            return action.get();
        }
        catch (Exception e){
            exceptionHandler.handleException(e);
            return null;
        }
    }
}
