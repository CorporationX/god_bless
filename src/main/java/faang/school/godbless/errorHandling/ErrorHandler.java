package faang.school.godbless.errorHandling;

import java.util.function.Supplier;

public class ErrorHandler {
    public <T> T withErrorHandling(Supplier<T> action, ExceptionHandler exceptionHandler){
        try{
            return action.get();
        }catch (Exception e){
            exceptionHandler.handleException(e);
            return null;
        }
    }
}
