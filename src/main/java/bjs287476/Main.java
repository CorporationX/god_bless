package bjs287476;

public class Main {
    public static void main(String[] args) {
        String result = ExceptionHandlerService.withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    System.out.println("error, returt default");
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }

    public static class RemoteService {
        public static String call(String param) {
            throw new RuntimeException("service is unavailable");
        }
    }
}
