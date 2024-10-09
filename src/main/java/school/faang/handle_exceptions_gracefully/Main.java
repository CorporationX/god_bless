package school.faang.handle_exceptions_gracefully;

public class Main {
    public static void main(String[] args) {
        //Using ErrorHandler with custom exception handling
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    System.out.println("Error occurred calling service, returning a default value");
                    return "DEFAULT";//Ensure to return "DEFAULT" after handling the exception
                }
        );
        //Output the result
        System.out.println(result);
    }

    //Simulating a remote service call
    public static class RemoteService {
        public static String call(String param) throws RuntimeException {
            //Simulate an exception for demonstration purposes
            throw new RuntimeException("Service is unavailable");
        }
    }
}