package faang.school.godbless.Sprint_3.Lambda.CSV;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T> {
    T join(List<T> vector);
}
