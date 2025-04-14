package school.faang.csv;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T> {

    String join(List<T> vector);
}
