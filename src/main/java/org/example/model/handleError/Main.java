package org.example.model.handleError;

public class Main {
    public static <T> T withErrorHandling(HandledErrorSupplier<T> action, ExceptionHandler<T> handler) {
        try {
            return action.get();
        } catch (Exception e) {
            return handler.catchHandler(e);
        }
    }

    public static void main(String[] args) {
        String result = Main.withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> "DEFAULT"
        );

        System.out.println(result);
    }

    public static class RemoteService {
        public static String call(String param) throws Exception {
            throw new Exception("Сервис недоступен");
        }
    }
}
