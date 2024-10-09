package school.faang.handlingerrorgracefully.maincode;

import java.util.function.Function;

public class ErrorHandler {
    public static <T> T withErrorHandling(ThrowingSupplier<T> supplier,
                                          Function<Exception, T> errorHandling) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return errorHandling.apply(e);
        }
    }
}
