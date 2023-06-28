package faang.school.godbless.lambda_stream.csv;

import java.util.List;

@FunctionalInterface
interface MatrixJoiner<T> {
    // Соединяет список списков элементов типа T в один элемент типа T
    T join(List<List<T>> matrix);
}
