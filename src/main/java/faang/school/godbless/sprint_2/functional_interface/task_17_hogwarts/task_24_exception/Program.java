package faang.school.godbless.sprint_2.functional_interface.task_17_hogwarts.task_24_exception;

import java.util.function.Function;

public class Program {

    public static void main(String[] args) {
        Function<Integer, String> function = number -> {
            if (number != 0) {
                return String.valueOf(number * 2);
            }
            throw new IllegalArgumentException("функция всё, но это не точно. 50 на 50, друзья.");
        };

        ExceptionHandler<String> handler = () -> {
            System.out.println("Не удалось получить доступ к Remote Service. Вернем default значение");
            return "MyDefault";
        };

        Integer validParameter = 5;
        Integer invalidParameter = 0;

        System.out.println("Тест валидного параметра: ");
        System.out.println(withErroringHandlig(validParameter, function, handler));

        System.out.println("Тест невалидного параметра: ");
        System.out.println(withErroringHandlig(invalidParameter, function, handler));
    }

    public static <T, R> R withErroringHandlig(T param, Function<T, R> remoteService, ExceptionHandler<R> exceptionHandler) {
        try {
            return remoteService.apply(param);
        } catch (Exception e) {
            return exceptionHandler.returnDefault();
        }
    }
}

