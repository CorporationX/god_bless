package school.faang.sprint_2.task_bjs246143;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T> {
    String join(List<T> vector);
}