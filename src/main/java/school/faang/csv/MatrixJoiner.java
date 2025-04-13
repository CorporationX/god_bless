package school.faang.csv;

import java.util.List;

@FunctionalInterface
public interface MatrixJoiner<T> {

    String join(List<List<T>> vector);
}
