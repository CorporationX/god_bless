package faang.school.godbless.greatexception;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        String normalTest = withErrorHandling(() -> {
            RemoteService remoteService = new RemoteService();
            return remoteService.call(123);
        }, exception -> "DEFAULT");

        System.out.println(normalTest);

        String exceptionTest = withErrorHandling(() -> {
            RemoteService remoteService = new RemoteService();
            return remoteService.call(null);
        }, exception -> "DEFAULT");

        System.out.println(exceptionTest);
    }

    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }
}
