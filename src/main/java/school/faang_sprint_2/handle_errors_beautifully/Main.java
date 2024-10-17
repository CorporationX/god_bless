package school.faang_sprint_2.handle_errors_beautifully;

public class Main {

    public static void main(String[] args) {

        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    System.out.println("Exception when calling service, return default value");
                    return "DEFAULT";
                }
        );
        System.out.println(result);

    }

    public static class RemoteService {
        public static String call(String param) {
            throw new RuntimeException("Service unavailable");
        }
    }
}
