package school.faang.task_46147;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T, R> {
    R join(List<T> vector);
}
