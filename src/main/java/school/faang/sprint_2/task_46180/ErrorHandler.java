package school.faang.sprint_2.task_46180;

import java.util.function.Function;
import java.util.function.Supplier;

public class ErrorHandler {

    //Решил не создавать собственный функциональный интерфейс, ведь можно воспользоваться функцией
    public static <T> T withErrorHandling(Supplier<T> action, Function<Exception, T> exceptionHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return exceptionHandler.apply(e);
        }
    }
}
