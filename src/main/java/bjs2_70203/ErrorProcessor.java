package bjs2_70203;

import java.util.function.Supplier;

public class ErrorProcessor {
    public static <T> T withErrorHandling(Supplier<T> theMainAction, ErrorHandler<T> errorCather) {
        try {
            return theMainAction.get();
        } catch (Exception e){
            return errorCather.handle(e);
        }
    }
}
