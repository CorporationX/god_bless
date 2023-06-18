package faang.school.godbless.sprint3.task2;

import java.util.List;

@FunctionalInterface
public interface MatrixJoiner<T> {

    T join(List<List<T>> matrix);
}
