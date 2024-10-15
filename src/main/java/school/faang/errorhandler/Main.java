package school.faang.errorhandler;

public class Main {
    public static void main(String[] args) {
        // Example of using withErrorHandling with a remote service call
        String result = ErrorHandler.withErrorHandling(
                () -> {
                    try {
                        return RemoteService.call("someParam");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                },  // Main action
                e -> {  // Error handling
                    System.out.println("Error during service call, returning default value");
                    return "DEFAULT";
                }
        );

        System.out.println(result);  // Will print: "DEFAULT" in case of an error
    }

    // Example method for a remote service
    public static class RemoteService {
        public static String call(String param) throws Exception {
            // Simulating an error for demonstration purposes
            throw new Exception("Service is unavailable");
        }
    }
}
