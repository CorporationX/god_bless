package school.faang.creatingCSV;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T> {
    T join(List<T> vector);
}