package faang.school.godbless;

import java.util.function.Supplier;

public class Application {
    public static void main(String[] args) {
        System.out.println("God Bless!");
    }

    @FunctionalInterface
    public interface ExceptionHandler<T> {
        T handle(Exception e);
    }

    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> onError) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return onError.handle(e);
        }
    }
}