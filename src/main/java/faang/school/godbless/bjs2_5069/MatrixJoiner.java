package faang.school.godbless.bjs2_5069;

import java.util.List;

@FunctionalInterface
public interface MatrixJoiner<T> {

    T join(List<List<T>> matrix);
}
