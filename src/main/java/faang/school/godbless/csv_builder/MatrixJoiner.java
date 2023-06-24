package faang.school.godbless.csv_builder;

import java.util.List;

@FunctionalInterface
public interface MatrixJoiner <T>{

    T join(List<List<T>> matrix);
}
