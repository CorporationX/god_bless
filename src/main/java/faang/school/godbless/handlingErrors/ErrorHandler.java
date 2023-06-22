package faang.school.godbless.handlingErrors;

import java.util.function.Function;

public class ErrorHandler {
    //принимает параметр, метод для обработки, метод для обработки ошибки
    public static <T, P> T withErrorHandling(P parameter, Function<P, T> function, ExceptionHandler<T> exceptionHandler) {
        try{
            return function.apply(parameter);
        } catch (Exception e) {
            return exceptionHandler.handleException(e);
        }
    }
}
