package faang.school.godbless.BJS2_21593;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T> {
    T join(List<T> vector);
}
