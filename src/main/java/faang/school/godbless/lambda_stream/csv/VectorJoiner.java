package faang.school.godbless.lambda_stream.csv;

import java.util.List;

@FunctionalInterface
interface VectorJoiner<T> {
    // Соединяет список элементов типа T в один элемент типа T
    T join(List<T> vector);
}
