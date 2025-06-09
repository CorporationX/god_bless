package school.faang.prettyerrors;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.concurrent.Callable;

/**
 * @author Danil Pudovkin
 * @since 09.06.2025
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorHandler {

    public static <T> T withErrorHandling(Callable<T> callable, ErrorHandlerFunction<T> function) {
        try {
            return callable.call();
        } catch (Exception e) {
            return function.apply(e);
        }
    }
}
