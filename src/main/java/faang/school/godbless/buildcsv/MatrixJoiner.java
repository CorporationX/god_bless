package faang.school.godbless.buildcsv;

import java.util.List;

@FunctionalInterface
public interface MatrixJoiner <T>{

    T join(List<List<T>> matrix);
}
