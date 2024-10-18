package school.faang.buildingcsv;

import java.util.List;

@FunctionalInterface
public interface MatrixJoiner<T> {
    T join(List<List<T>> matrix);
}
