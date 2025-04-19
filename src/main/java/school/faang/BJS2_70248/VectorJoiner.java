package school.faang.BJS2_70248;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T> {
    String join(List<T> vector);
}