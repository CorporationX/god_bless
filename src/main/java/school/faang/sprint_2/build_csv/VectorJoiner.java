package school.faang.sprint_2.build_csv;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T> {
    String join(List<T> vector);
}
