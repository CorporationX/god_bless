package faang.school.godbless.csv;

import java.util.*;

@FunctionalInterface
public interface VectorJoiner<T> {
    T join(List<T> vector);
}
