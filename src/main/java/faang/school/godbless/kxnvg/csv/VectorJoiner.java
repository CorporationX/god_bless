package faang.school.godbless.kxnvg.csv;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T> {

    T join(List<T> vector);
}
