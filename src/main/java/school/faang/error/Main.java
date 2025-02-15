package school.faang.error;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandling.withErrorHandling(() -> RemoteService.call(), e -> {
                    System.err.println("Error: " + e.getMessage());
                    return "Default";
                }
        );
    }
}
