package faang.school.godbless.BJS2_5371;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> {
            System.out.println("Hi");
            return "Hello";
        };
        Supplier<String> task = () -> {
            throw new IllegalArgumentException("error");
        };

        System.out.println(withErrorHandling(supplier, exception -> "exception"));
        System.out.println(withErrorHandling(task, exception -> "exception"));
    }

    private static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> onError) {
        try {
            return action.get();
        } catch (Exception e) {
            return onError.handle(e);
        }
    }
}
