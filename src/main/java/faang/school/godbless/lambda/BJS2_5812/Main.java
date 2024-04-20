package faang.school.godbless.lambda.BJS2_5812;

import java.util.Random;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        String result = withErrorHandling(
                () -> {
                    if (new Random().nextBoolean()) {
                        throw new RuntimeException("Что-то пошло не так :(");
                    }
                    return "Работает";
                },
                (exception) -> {
                    System.out.println("Не удалось выполнить операцию, возвращаем default value");
                    System.out.println(exception.toString());
                    return "DEFAULT";
                }
        );

        System.out.println("Результат операции - " + result);
    }

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> exceptionHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }
}
