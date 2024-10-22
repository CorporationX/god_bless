package school.faang.handleExceptions;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        RemoteService remoteService = new RemoteService();
        ErrorHandler errorHandler = new ErrorHandler();
        String result = errorHandler.withErrorHandling(
                () -> remoteService.call("params"),
                e -> {
                    System.out.println("Returning default value : " + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
                    return "DEFAULT";
                }
        );
        System.out.println(result);
    }

    public static class RemoteService {
        public String call(String param) {
            throw new IllegalStateException("Remote service error");
        }
    }
}
