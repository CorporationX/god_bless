package school.faang.exceptionhandler;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {

    public <T> T withErrorHandling(Supplier<T> supplier, Function<Exception, T> function){
        try {
            return supplier.get();
        } catch (Exception e) {
            return function.apply(e);
        }
    }
}
