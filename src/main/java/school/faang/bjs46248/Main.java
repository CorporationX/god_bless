package school.faang.bjs46248;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        String res = withErrorHandling(() -> {
            if (1 == 1) {
                throw new RuntimeException();
            }
            return "Hello, world! (Main)";
        }, e -> {
            if (e instanceof RuntimeException) {
                return "Hello, world! (from handler)";
            }
            return null;
        });
        System.out.println(res);
    }

    public static <T> T withErrorHandling(Supplier<T> mainAction, Function<Exception, T> errorHandler) {
        try {
            return mainAction.get();
        } catch (Exception e) {
            return errorHandler.apply(e);
        }
    }
}
