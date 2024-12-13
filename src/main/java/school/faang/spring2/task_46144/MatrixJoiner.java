package school.faang.spring2.task_46144;

import java.util.List;

@FunctionalInterface
public interface MatrixJoiner<T> {
    T join(List<List<T>> matrix);
}