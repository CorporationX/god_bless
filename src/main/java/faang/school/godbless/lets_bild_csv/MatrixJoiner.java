package faang.school.godbless.lets_bild_csv;

import java.util.List;
@FunctionalInterface
public interface MatrixJoiner<T> {
    T join(List<List<T>> matrix);
}
