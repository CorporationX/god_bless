package faang.school.godbless.csv;

import lombok.NonNull;

import java.util.List;
import java.util.Objects;

@FunctionalInterface
interface VectorJoiner<T> {
    // Соединяет список элементов типа T в один элемент типа T
    T join(List<T> vector);
}

@FunctionalInterface
interface MatrixJoiner<T> {
    // Соединяет список списков элементов типа T в один элемент типа T
    T join(List<List<T>> matrix);
}

public class Csv {
    public static String toCsv(@NonNull List<List<String>> table) {
        VectorJoiner<String> vectorJoiner = vector -> {
            return String.join(", ", vector);
        };
        MatrixJoiner<String> matrixJoiner =
                matrix -> String.join(",\n", matrix.stream()
                        .filter(Objects::nonNull)
                        .map(vectorJoiner::join).toList());
        return matrixJoiner.join(table);
    }
}
