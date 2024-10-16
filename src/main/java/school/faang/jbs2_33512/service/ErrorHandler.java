package school.faang.jbs2_33512.service;

import lombok.NonNull;
import school.faang.jbs2_33512.functional.CheckedSupplier;

import java.util.function.Function;

public class ErrorHandler {
    public static <T> T withErrorHandling(@NonNull CheckedSupplier<T> basicAction, @NonNull Function<Exception, T> errorHandling) {
        T result;
        try {
            result = basicAction.run();
        } catch (Exception e) {
            return errorHandling.apply(e);
        }
        return result;
    }
}
