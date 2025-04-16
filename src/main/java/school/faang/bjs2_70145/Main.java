package school.faang.bjs2_70145;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("Test"),
                e -> {
                    System.out.println(e.getMessage());
                    return "Default";
                }
        );
    }
}
