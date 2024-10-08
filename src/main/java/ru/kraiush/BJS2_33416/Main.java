package ru.kraiush.BJS2_33416;

public class Main {

    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("Hello!"),
                e -> {
                    System.out.println("Remote Service response error, return the default value.");
                    return "DEFAULT";
                }
        );
        System.out.println(result);
    }

    public static class RemoteService<T> {
        public static String call(String param) throws Exception {
            throw new Exception("Service is not available");
        }
    }
}
