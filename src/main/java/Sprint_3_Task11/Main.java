package Sprint_3_Task11;

import java.util.function.Supplier;

public class Main {

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> onError){
        try {
            return action.get();
        }catch (Exception e){
            return onError.handle(e);
        }
    }
}
