package faang.school.godbless.lambda.buildCSV;

import java.util.List;

@FunctionalInterface
public interface MatrixJoiner<T> {
    // ��������� ������ ������� ��������� ���� T � ���� ������� ���� T
    T join(List<List<T>> matrix);
}
