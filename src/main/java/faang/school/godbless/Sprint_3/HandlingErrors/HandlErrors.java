package faang.school.godbless.Sprint_3.HandlingErrors;

import java.util.function.Supplier;

public class HandlErrors {
    public static <T> T withErrorHandling(Supplier<T> suplier, ExceptionHandler<T> exceptionHandler) {
        try {
            return suplier.get();
        } catch (Exception e) {
            return exceptionHandler.exception(e);
        }
    }
}
