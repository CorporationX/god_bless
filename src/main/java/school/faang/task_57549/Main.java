package school.faang.task_57549;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        String result = withErrorHandling(
                () -> RemoteService.call("someParam"),
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

    public static class RemoteService {
        public static String call(String param) {
            throw new RuntimeException("The service is unavailable");
        }
    }

    public interface ExceptionHandler<T> {
        T handle(Exception e);
    }
}
