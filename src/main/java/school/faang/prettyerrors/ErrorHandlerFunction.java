package school.faang.prettyerrors;

import java.util.function.Function;

/**
 * @author Danil Pudovkin
 * @since 09.06.2025
 */
@FunctionalInterface
public interface ErrorHandlerFunction<T> extends Function<Exception, T> {
}
