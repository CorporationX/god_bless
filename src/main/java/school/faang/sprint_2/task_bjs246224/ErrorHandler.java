package school.faang.sprint_2.task_bjs246224;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.function.Function;
import java.util.function.Supplier;

@UtilityClass
public class ErrorHandler {
    public <T> T withErrorHandling(@NonNull Supplier<T> action,
                                   @NonNull Function<Exception, T> exceptionHandler) {
        try {
            return action.get();
        } catch (Exception e) {
            return exceptionHandler.apply(e);
        }
    }
}
