package school.faang.task_45587;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T> {

    T join(List<T> vector);
}
