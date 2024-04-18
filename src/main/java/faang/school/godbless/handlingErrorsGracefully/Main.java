package faang.school.godbless.handlingErrorsGracefully;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        String result = withErrorHandling(
                () -> remoteServiceCall("param"),
                e -> {
                    System.out.println("Не удалось получить доступ к Remote Service. Вернем default значение");
                    return "DEFAULT";
                }
        );

        System.out.println("Result: " + result);
    }

    public static String remoteServiceCall(String param)  {
        try {
            throw new Exception("Remote Service is not available");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> onError) {
        try {
            return action.get();
        } catch (Exception e) {
            return onError.handle(e);
        }
    }
}