package school.faang.bjs2_70555;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public record NotificationHandler<T>(Predicate<T> filter, Function<T, String> signature, Consumer<T> print) {
}
