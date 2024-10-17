package Sprint_2.BJS2_34296;

import java.util.List;

@FunctionalInterface
public interface MatrixJoiner<T> {
    T join(List<List<T>> matrix);
}
