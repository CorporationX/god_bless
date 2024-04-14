package faang.school.godbless.bjs2_5069;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T> {

    T join(List<T> vector);
}
