package school.faang.BJS2_34267_BuildingCsv;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T> {
    T join(List<T> vector);
}
