package faang.school.godbless.BJS2_21128;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<String> action = () -> "The call to the remote service was successful";
        Supplier<String> exceptionAction = () -> {
            throw new RuntimeException("Service unavailable");
        };
        ExceptionHandler<String> handler = exception -> "DEFAULT";
        System.out.println(ExceptionProcessor.withErrorHandling(action, handler));
        System.out.println(ExceptionProcessor.withErrorHandling(exceptionAction, handler));
    }
}
