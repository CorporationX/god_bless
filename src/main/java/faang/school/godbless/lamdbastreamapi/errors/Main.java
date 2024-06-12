package faang.school.godbless.lamdbastreamapi.errors;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<String> call = () -> "4";
        ExceptionHandler<String> exceptionHandler = (e) -> {
            System.out.println("Не удалось получить доступ к Remote Service. Вернем default значение");
            return "DEFAULT";
        };

        System.out.println(withErrorHandling(call, exceptionHandler));
    }

    public static <T> T withErrorHandling(Supplier<T> call, ExceptionHandler<T> exceptionHandler) {
        try {
            return call.get();
        } catch (Exception e) {
            return exceptionHandler.excetptionProcessor(e);
        }
    }
}
