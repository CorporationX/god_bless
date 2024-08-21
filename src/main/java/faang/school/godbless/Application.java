package faang.school.godbless;

import java.util.function.Supplier;

public class Application {
    public static void main(String[] args) {
        System.out.println("God Bless!");
    }

    public static <T> T withErrorHandling(Supplier<T> remoteService, ExceptionHandler<T> exceptionHandler) {
        try {
            return remoteService.get();
        } catch (Exception e) {
            return exceptionHandler.onException(e);
        }

    }
}