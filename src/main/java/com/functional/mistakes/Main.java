package com.functional.mistakes;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        // 1 пример создание
        ExceptionHandler<Exception> errorHandling = e -> System.out.println(e.toString());
        Supplier<Email> supplier = () -> new Email("", 232);

        Handler.withErrorHandling(errorHandling, supplier);

        // 2 пример создание
        Handler.withErrorHandling(e ->
                System.out.println(e.toString()), () -> new Email("", 23));
        // либо так
        Handler.withErrorHandling(Throwable::printStackTrace, () -> new Email("", 23));

        System.out.println("Программа еще работает");
    }
}
