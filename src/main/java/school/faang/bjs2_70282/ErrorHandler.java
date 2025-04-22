package school.faang.bjs2_70282;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {

    public static String withErrorHandling(Supplier<String> action, Function<Exception, String> exceptionHandler) {
        String retValue;
        try {
            retValue = action.get();
        } catch (Exception e) {
            retValue = exceptionHandler.apply(e);
        }
        return retValue;
    }
}
