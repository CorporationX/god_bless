package faang.school.godbless.functionalInterfaces.exceptions;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandlingService {

    public static <T> T executeWithErrorHandling(Supplier<T> regularAction, Function<Exception, T> errorAction) {
        if (regularAction == null || errorAction == null) {
            throw new IllegalArgumentException("Both args must be non-valued!");
        }

        try {
            return regularAction.get();
        } catch (Exception e) {
            return errorAction.apply(e);
        }
    }
}
