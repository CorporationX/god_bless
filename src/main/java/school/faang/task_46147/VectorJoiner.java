package school.faang.task_46147;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T extends String> {
    T join(List<T> vector);
}
