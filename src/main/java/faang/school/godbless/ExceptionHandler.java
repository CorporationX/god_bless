package faang.school.godbless;

import java.util.function.Supplier;

@FunctionalInterface
public interface ExceptionHandler<T> {
    T handle(Exception e);

    static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return exceptionHandler.handle(e);
        }
    }
}
