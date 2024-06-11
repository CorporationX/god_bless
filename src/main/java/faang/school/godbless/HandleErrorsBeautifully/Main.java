package faang.school.godbless.HandleErrorsBeautifully;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Подключение успешно";
        ExceptionHandler<String> exceptionHandler = (e) -> e + " ошибка";
        System.out.println(withErrorHandling(supplier, exceptionHandler));
    }

    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> errorHandling) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return errorHandling.warn(e);
        }
    }
}
