package Handle_Errors_Beautifully;

import java.util.function.Supplier;

public class ExceptionHandlerClass {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> onError){
        try{
            return action.get();
        }catch (Exception exception){
            return onError.handle(exception);
        }
    }
}
