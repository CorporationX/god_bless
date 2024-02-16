package faang.school.godbless.errorshandling;

import java.util.function.Supplier;

public class Main {
    public static void main(String... args) {
        System.out.println(withErrorHandling(() -> (10 / 0), (T) -> "error"));
    }

    public static <T> T withErrorHandling(Supplier<T> toDo, ExceptionHandler<T> onError) {
        try {
            return toDo.get();
        } catch (Exception e) {
            return onError.handle(e);
        }
    }
}
