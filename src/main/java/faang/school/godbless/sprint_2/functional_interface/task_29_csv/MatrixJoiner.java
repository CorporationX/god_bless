package faang.school.godbless.sprint_2.functional_interface.task_29_csv;

import java.util.List;

@FunctionalInterface
public interface MatrixJoiner<T> {
    T join(List<List<T>> matrix);
}
