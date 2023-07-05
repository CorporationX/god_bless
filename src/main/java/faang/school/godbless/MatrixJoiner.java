package faang.school.godbless;

import java.util.List;

@FunctionalInterface
public interface MatrixJoiner<T> {
    T join (List<List<T>> matrix);
}
