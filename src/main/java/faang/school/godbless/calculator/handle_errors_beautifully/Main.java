package faang.school.godbless.calculator.handle_errors_beautifully;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static <T> T withErrorHandling(Supplier<T> callingServer, ExceptionHandler<T> handlingError){
        try {
            return callingServer.get();
        }catch (Exception e){
            return handlingError.handleError(e);
        }
    }
}
