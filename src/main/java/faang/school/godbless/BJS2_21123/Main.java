package faang.school.godbless.BJS2_21123;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String, Integer> function1 = string -> {
            int sumCodes = string.chars().sum();
            if (sumCodes % 2 == 0) {
                return sumCodes;
            } else {
                throw new IllegalArgumentException("Нечетная сумма");
            }
        };
        ExceptionHandler<Integer> exceptionHandler1 = exception -> {
            System.out.println("Получили исключение с сообщением: " + exception.getMessage());
            return 0;
        };

        System.out.println(RemoteService.withErrorHandling("Robert", function1, exceptionHandler1));
        System.out.println(RemoteService.withErrorHandling("Vlad", function1, exceptionHandler1));
    }
}
