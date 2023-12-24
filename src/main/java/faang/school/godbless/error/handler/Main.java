package faang.school.godbless.error.handler;

public class Main {
    public static void main(String[] args) {
        ErrorHandler.withErrorHandling(
                () -> {
                    String result = "resolved";
                    System.out.println("method called");
                    return result;
                },
                (e) -> {
                    System.out.println("An error occurred: " + e.getMessage());
                    return "rejected";
                });
    }
}
