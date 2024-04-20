package faang.school.godbless.exeptions;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<String> supplier1 = () -> "OK";
        Supplier<String> supplier2 = () -> {
            throw new RuntimeException();
        };
        ExceptionHandler<String> exceptionHandler = (exception) -> "Default";

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
