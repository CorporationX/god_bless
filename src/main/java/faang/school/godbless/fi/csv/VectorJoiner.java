package faang.school.godbless.fi.csv;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T> {

    T join(List<T> vector);

}
