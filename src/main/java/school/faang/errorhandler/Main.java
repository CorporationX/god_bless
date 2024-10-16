package school.faang.errorhandler;

public class Main {
    public static void main(String[] args) {
        RemoteService remoteService = new RemoteService();

        String result = ErrorHandler.withErrorHandling(
                () -> remoteService.call("someParam"),  // Основное действие
                e -> {
                    System.out.println("Error during service call, returning default value");
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }
}
