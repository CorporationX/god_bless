package bjs2_33433;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<String> reject = () -> {
            throw new RuntimeException("Oops");
        };

        Supplier<String> success = () -> "congratulations!";

        String call1 = ErrorHandler.withErrorHandling(
                reject,
                (Exception exception) -> {
                    System.out.println(exception.getMessage());
                    return "default value";
                }
        );

        String call2 = ErrorHandler.withErrorHandling(
                success,
                (Exception exception) -> {
                    System.out.println(exception.getMessage());
                    return "default value";
                }
        );

        System.out.println(call1);
        System.out.println(call2);
    }
}
