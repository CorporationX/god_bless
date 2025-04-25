package school.faang.sprint_2.build_csv;

import java.util.List;

@FunctionalInterface
public interface MatrixJoiner<T> {
    String join(List<List<T>> vector);
}
