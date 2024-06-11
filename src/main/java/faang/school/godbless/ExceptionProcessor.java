package faang.school.godbless;

import java.util.function.Supplier;

public class ExceptionProcessor {
    public static <T> T withErrorHandling (Supplier<T> tryToDo, ExceptionHandler<T> ifCatchSomething) {
        try {
            return tryToDo.get();
        } catch (Exception e){
            return ifCatchSomething.handle(e);
        }
    }
}