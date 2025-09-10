package school.faang.bjs2_87565;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        String result = withErrorHandling(() -> Service.message(null),
                e -> {
                    System.out.println("ERROR!!!!!!!!!!!!!!!!");
                    return "Default";
                });
        System.out.println(result);
    }

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> exceptionHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }
}

