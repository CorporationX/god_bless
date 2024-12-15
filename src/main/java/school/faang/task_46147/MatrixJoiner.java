package school.faang.task_46147;

import java.util.List;

@FunctionalInterface
public interface MatrixJoiner<T, R> {
    R join(List<List<T>> matrix);
}
