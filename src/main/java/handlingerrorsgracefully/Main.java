package handlingerrorsgracefully;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandle.withErrorHandling(
                () -> RemoteService.call("Hello"),
                e -> {
                    System.out.println("Error: " + e.getMessage());
                    return "default response";
                }
        );

        System.out.println("Result of service: " + result);
    }
}
