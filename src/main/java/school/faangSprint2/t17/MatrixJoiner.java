package school.faangSprint2.t17;

import java.util.List;

@FunctionalInterface
interface MatrixJoiner<T> {
    T join(List<List<T>> matrix);
}