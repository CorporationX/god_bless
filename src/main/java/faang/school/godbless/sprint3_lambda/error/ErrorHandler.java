package faang.school.godbless.sprint3_lambda.error;

import java.util.function.Supplier;

public class ErrorHandler {
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> onError) {
        try { // try-catch для перехвата исключ
            return action.get(); // возвращение знач, полученного из вызова метода get() у объекта action, get() явл методом Supplier<T>, который возвращает знач типа T
        } catch (Exception e) { // catch перехватывает исключение
            return onError.handle(e); // возвращ знач, полученного из вызова метода handle() у объекта onError; метод handle(Exception e) принимает искл e в качестве параметра
        }
    }
}
