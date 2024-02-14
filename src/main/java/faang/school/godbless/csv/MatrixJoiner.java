package faang.school.godbless.csv;

import java.util.*;

@FunctionalInterface
public interface MatrixJoiner<T> {
    T join(List<List<T>> matrix);
}
