package school.faang.bjs2_91611;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println(withErrorHandling(() -> {
            System.out.println("Make some Exception");
            throw new RuntimeException("Exception is happened");
        }, Throwable::toString));
    }

    private static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }
}
