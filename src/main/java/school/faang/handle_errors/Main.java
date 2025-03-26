package school.faang.handle_errors;

public class Main {
    public static void main(String[] args) {

        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    System.out.println("Error calling service, returning default value");
                    return "DEFAULT";
                }
        );
        System.out.println(result);
    }

    public static class RemoteService {
        public static String call(String param) {
            throw new RuntimeException("Service unavailable!");
        }
    }
}