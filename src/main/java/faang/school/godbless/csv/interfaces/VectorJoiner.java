package faang.school.godbless.csv.interfaces;

import java.util.List;
@FunctionalInterface
public interface VectorJoiner<T> {
    T join(List<T> vector);
}
