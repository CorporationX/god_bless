package school.faang.godbless.bjs2_34252;

import java.util.List;

@FunctionalInterface
public interface MatrixJoiner<T> {
    T join(List<List<T>> matrix);
}
