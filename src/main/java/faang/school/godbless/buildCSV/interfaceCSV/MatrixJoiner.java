package faang.school.godbless.buildCSV.interfaceCSV;

import java.util.List;

public interface MatrixJoiner<T> {
    T join(List<List<T>> matrix);
}
