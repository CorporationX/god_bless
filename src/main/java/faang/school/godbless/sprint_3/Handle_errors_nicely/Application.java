package faang.school.godbless.sprint_3.Handle_errors_nicely;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Application {

    public static void main(String... args) {


        withErrorHandling(() -> {
            System.out.println("success");
            throw new RuntimeException();
        }, (exception -> {
            exception.printStackTrace();
            return false;
        }));
    }

    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T, Exception> errorHandling) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return errorHandling.apply(e);
        }
    }

/*Написать статический метод withErrorHandling,
который состоит из 2 действий.

Принимает 2 лямбды: одну то, что нужно сделать;
другая то, что нужно сделать при ошибке первого действия.

Метод должен быть параметризован, и возвращать тип T.

Вторая лямбда должна принимать Exception.
Такого функционального интерфейса в Java нет, напишите свой с названием ExceptionHandler.

Подумайте, какой функциональный интерфейс подойдёт для первого действия?*/
}
