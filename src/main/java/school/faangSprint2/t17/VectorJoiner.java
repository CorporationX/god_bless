package school.faangSprint2.t17;

import java.util.List;

@FunctionalInterface
interface VectorJoiner<T> {
    T join(List<T> vector);
}