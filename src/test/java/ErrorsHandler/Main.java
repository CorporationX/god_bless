package ErrorsHandler;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> callRemoteService("meaning"),
                 e -> {
                    System.out.println("Error when calling the service, return default value");
                    return "Defolt";
                }
        );

    }

    public static String callRemoteService(String meaning) throws Exception {
        throw new Exception("Service unavailable");
    }

}
