package school.faang.BJS2_70248;

import java.util.List;

@FunctionalInterface
public interface MatrixJoiner<T> {
    String join(List<List<T>> matrix);
}