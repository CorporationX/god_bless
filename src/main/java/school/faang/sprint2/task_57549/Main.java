package school.faang.sprint2.task_57549;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        RemoteService remoteService = new RemoteService();
        String result = withErrorHandling(
                () -> remoteService.call("someParam"),
                e -> {
                    System.out.println("Error when calling the service, we return the default value");
                    return "DEFAULT";
                }
        );
        System.out.println(result);
    }

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> errorHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return errorHandler.handle(e);
        }
    }
}
