package school.faang.pretty.error.handling;

import java.util.Random;

public class Main {
    static final int SERVICE_AVAILABILITY = new Random().nextInt(10);

    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    System.out.println("Error when calling a remote service, returning default value");
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }

    public static class RemoteService {
        public static String call(String param) throws Exception {
            if (SERVICE_AVAILABILITY > 0) {
                return "Connecting to a service using "+ param;
            } else {
                throw new Exception("Service unavailable");
            }
        }
    }
}
