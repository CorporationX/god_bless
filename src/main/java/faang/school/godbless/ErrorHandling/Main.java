package faang.school.godbless.ErrorHandling;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    @SuppressWarnings("unchecked")
    public static <T extends Exception, U, V> V withErrorHandling(Function<U, V> function, U param, ExceptionHandler<T> errorHandling) throws T {
        try {
            return function.apply(param);
        } catch (Exception e) {
            throw errorHandling.handle((T) e);

        }
    }

    public static void main(String[] args) {
        Function<String, Integer> parseIntFunction = Integer::parseInt;
        ExceptionHandler<NumberFormatException> handler = ex -> {
            System.err.println("Ошибка преобразования строки в число: " + ex.getMessage());
            return new NumberFormatException("Не удалось преобразовать строку в число: " + ex.getMessage());
        };
        try {
            Integer result = withErrorHandling(parseIntFunction, "123", handler);
            System.out.println("Результат: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Исключение обработано: " + e.getMessage());
        }
    }
}

