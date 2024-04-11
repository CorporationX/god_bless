package BJS2_5259;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        RemoteService remoteService = new RemoteService();
        String testNoException = withErrorHandling(() -> remoteService.call(true), Throwable::getMessage);
        String testWithException = withErrorHandling(() -> remoteService.call(false), Throwable::getMessage);

        System.out.println(testNoException);
        System.out.println(testWithException);
    }

    private static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> handler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return handler.handle(e);
        }
    }
}
