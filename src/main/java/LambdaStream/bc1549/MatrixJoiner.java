package LambdaStream.bc1549;

import java.util.List;

@FunctionalInterface
public interface MatrixJoiner<T> {
    // Соединяет список списков элементов типа T в один элемент типа T
    T join(List<List<T>> matrix);
}
