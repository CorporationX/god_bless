package faang.school.godbless.Sprint_3.CSV;

import java.util.List;

public interface MatrixJoiner<T> {
    T join(List<List<T>> matrix);
}
