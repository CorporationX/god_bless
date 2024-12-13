package school.faang.spring2.task_46144;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T> {
    T join(List<T> vector);
}
