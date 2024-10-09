package school.faang.handlingerrors;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        String result = withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    System.out.println("Error! Return default value");
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }

    public static <T> T withErrorHandling(Supplier<T> action, Function<Exception, T> handler) {
        try {
            return action.get();
        } catch (Exception e) {
            return handler.apply(e);
        }
    }

    public static class RemoteService {
        public static String call(String param) {
            throw new RuntimeException("Service is unavailable");
        }
    }
}
