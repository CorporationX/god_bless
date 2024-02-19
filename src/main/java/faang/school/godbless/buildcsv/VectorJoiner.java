package faang.school.godbless.buildcsv;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner <T> {

    T join(List<T> vector);
}
