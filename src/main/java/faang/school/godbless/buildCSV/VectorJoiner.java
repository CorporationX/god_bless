package faang.school.godbless.buildCSV;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T> {
    // ��������� ������ ��������� ���� T � ���� ������� ���� T
    T join(List<T> vector);
}
