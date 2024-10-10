package school.faang.Errors;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(ErrorSupplier<T> supplier, Function<Exception, T> function) {
        try{
            return supplier.get();
        } catch (Exception e){
            return function.apply(e);
        }
    }
}
