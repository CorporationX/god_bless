package faang.school.godbless.handle_exceptions;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Supplier<String> supplier1 = () -> "Without exceptions";
        Supplier<String> supplier2 = () -> {
            throw new RuntimeException();
        };
        ExceptionHandler<String> exceptionHandler = (e) -> {
            log.warn("Failed to execute lambda expression. Return default value.");
            return "Default value";
        };

        System.out.println(handlingExceptions(supplier1, exceptionHandler));
        System.out.println(handlingExceptions(supplier2, exceptionHandler));
    }

    public static <T> T handlingExceptions(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }
}