package faang.school.godbless.Calculator;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

@FunctionalInterface
public interface Calculator<T extends Number> {
    T apply(T a, T b);
}
