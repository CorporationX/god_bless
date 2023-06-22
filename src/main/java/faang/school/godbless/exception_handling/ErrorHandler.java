package faang.school.godbless.exception_handling;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> handler){
        try {
           return action.get();
        } catch (Exception e){
           return handler.handle(e);
        }
    }

    public static void main(String[] args) {
        Supplier<String> action = () -> "Hello world";
        ExceptionHandler<String> handler = (e) -> "An error occured: " + e.getMessage();
        withErrorHandling(action, handler);
    }
}
