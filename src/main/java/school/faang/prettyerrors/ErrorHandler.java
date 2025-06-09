package school.faang.prettyerrors;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.concurrent.Callable;
import java.util.function.Function;

/**
 * @author Danil Pudovkin
 * @since 09.06.2025
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorHandler {

    public static String withErrorHandling(Callable<String> callable, Function<Exception, String> function) {
        try {
            return callable.call();
        } catch (Exception e) {
            return function.apply(e);
        }
    }
}
