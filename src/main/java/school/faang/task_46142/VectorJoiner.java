package school.faang.task_46142;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T> {

    T join(List<T> vector);
}
