package faang.school.godbless.Handling.errors.beautifully;

import java.util.function.Supplier;

public class Application {

    public static void main(String[] args) {

        //Тест без вылета исключения
        Supplier<String> supplier1 = () -> "Никто не видел моё исключение? Кажется, я его где-то обронил";
        ExceptionHandler<String> exceptionHandler1 = exception -> exception.getMessage();

        System.out.println(ErrorHandler.withErrorHandling(supplier1, exceptionHandler1));

        //Тест с исключением
        Supplier<String> supplier = () -> {
            throw new RuntimeException("Стойте, нашёл, вот же оно!");
        };
        ExceptionHandler<String> exceptionHandler = exception -> exception.getMessage();

        System.out.println(ErrorHandler.withErrorHandling(supplier, exceptionHandler));
    }
}
