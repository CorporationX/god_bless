package school.faang.task_45587;

import java.util.List;

@FunctionalInterface
public interface MatrixJoiner<T> {

    T join(List<List<T>> matrix);
}
