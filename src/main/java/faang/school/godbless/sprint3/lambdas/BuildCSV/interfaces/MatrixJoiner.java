package faang.school.godbless.sprint3.lambdas.BuildCSV.interfaces;

import java.util.List;

@FunctionalInterface
public interface MatrixJoiner<T> {
    T join(List<List<T>> matrix);
}
