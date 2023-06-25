package faang.school.godbless.lambda.errors;

import java.util.function.Supplier;

public class ErrorHandling {
    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler <T> exception) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return exception.handle(e);
        }
    }
}
