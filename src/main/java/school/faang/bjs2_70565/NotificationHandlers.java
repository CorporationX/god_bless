package school.faang.bjs2_70565;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public record NotificationHandlers<T>(
    Consumer<T> action, Predicate<T> filter, Function<T, String> footer
) {
}
