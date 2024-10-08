package school.faang.errorhandling;

import lombok.Setter;

import java.util.function.Function;

@Setter
public class ErrorHandler {

    public static <T> T withErrorHandling(SupplierWithException<T> executableCall, Function<Exception, T> errorHandler) {
        try {
            return executableCall.get();
        } catch (Exception ex) {
            return errorHandler.apply(ex);
        }
    }
}
