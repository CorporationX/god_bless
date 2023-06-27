package faang.school.godbless.mistakes;

import java.util.function.Supplier;

public class Handling {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> exceptionHandler){
        try {
            return action.get();
        } catch (Exception e){
            return exceptionHandler.handWithException(e);
        }
    }


}
