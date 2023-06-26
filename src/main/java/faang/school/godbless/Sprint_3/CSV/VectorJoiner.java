package faang.school.godbless.Sprint_3.CSV;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T> {
    T join(List<T> vector);
}
