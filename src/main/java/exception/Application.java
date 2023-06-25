package exception;

import java.util.function.Supplier;

public class Application {
    public static void main(String[] args) {
        //Тест без вылета исключения
        Supplier<String> supplierWithOutException = () -> "Штатная работа без ошибки";
        ExceptionHandler<String> exceptionHandler1 = exception -> exception.getMessage();

        System.out.println(ErHandler.withErrorHandling(supplierWithOutException, exceptionHandler1));

        //Тест с исключением
        Supplier<String> supplierWithException = () -> {
            throw new RuntimeException("Выбрасывается исключение");
        };
        ExceptionHandler<String> exceptionHandler = exception -> exception.getMessage();

        System.out.println(ErHandler.withErrorHandling(supplierWithException, exceptionHandler));
    }
}
