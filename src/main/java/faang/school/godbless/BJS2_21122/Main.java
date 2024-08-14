package faang.school.godbless.BJS2_21122;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Integer, Integer> function = a -> {
            a += 2;
            if (a % 2 == 0) {
                return a;
            } else {
                throw new IllegalArgumentException("число нечетное");
            }
        };
        ExceptionHandler<Integer> exceptionHandler = exception -> {
            System.out.println("Получили исключение с сообщением: " + exception.getMessage());
            return 0;
        };

        System.out.println(RemoteService.withErrorHandling(15, function, exceptionHandler));
    }
}
