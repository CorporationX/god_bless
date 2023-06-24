package faang.school.godbless.csv_builder;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner <T>{

    T join(List<T> vector);
}
