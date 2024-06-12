package faang.school.godbless.lambda;

import java.util.Random;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Supplier<String> stringSupplier = () -> {
            int randomInt = new Random().nextInt();
            if (randomInt % 2 == 0) {
                throw new RuntimeException("В ответ ошибка");
            }
            return String.valueOf(randomInt);
        };

        System.out.println(ExceptionProcessor.withErrorHandling(stringSupplier, e -> e.getMessage()));

    }
}
