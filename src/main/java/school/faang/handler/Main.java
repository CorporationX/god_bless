package school.faang.handler;

import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) {
        String callService = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("Main Action"),
                exception -> {
                    System.out.println("Error when calling");
                    return "DEFAULT";
                }
        );
        System.out.println(callService);
    }

    public static class RemoteService {
        public static String call(String param) {
            throw new RuntimeException("Сервис недоступен");
        }
    }
}
