package school.faang.bjs2_80220;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T> {
    T join(List<T> vector);
}
