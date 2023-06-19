package faang.school.godbless.task.csv;

import java.util.List;

public interface MatrixJoiner<T> {
    T join(List<List<T>> matrix);
}
