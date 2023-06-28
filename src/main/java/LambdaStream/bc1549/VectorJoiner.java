package LambdaStream.bc1549;

import java.util.List;

@FunctionalInterface
public interface VectorJoiner<T> {
    // Соединяет список элементов типа T в один элемент типа T
    T join(List<T> vector);
}
