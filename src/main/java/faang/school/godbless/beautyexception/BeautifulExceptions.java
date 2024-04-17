package faang.school.godbless.beautyexception;

import java.util.function.Supplier;

public class BeautifulExceptions {
    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> error) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return error.handleException(e);
        }
    }
}
