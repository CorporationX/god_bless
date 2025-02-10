package school.faang.handle_errors;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {

    public static <T> T withErrorHandling(Supplier<T> supplier, Function<Exception, T> errorProcessing) {

        try {
            return supplier.get();
        } catch (Exception e) {
            System.out.println(new StringBuilder("Error information: ").append(e.getMessage()));
            return errorProcessing.apply(e);
        }
    }
}
