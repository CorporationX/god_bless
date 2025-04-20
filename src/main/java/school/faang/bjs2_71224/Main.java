package school.faang.bjs2_71224;

public class Main {
    public static void main(String[] args) {
        ErrorHandler<String> errorHandler = new ErrorHandler<>();
        String result = errorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    System.out.println("Error, returning default value...");
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }

    public static class RemoteService {
        public static String call(String param) {
            throw new RuntimeException("Сервис недоступен");
        }
    }
}
