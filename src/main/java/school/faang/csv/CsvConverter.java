package school.faang.csv;

import java.util.List;
import java.util.stream.Collectors;

public class CsvConverter {
    public static String toCsv(List<List<String>> table) {
        VectorJoiner<String> vectorJoiner = vector ->
                vector.stream().collect(Collectors.joining(","));

        MatrixJoiner<String> matrixJoiner = matrix ->
                matrix.stream()
                        .map(vectorJoiner::join)
                        .collect(Collectors.joining("\n"));

        return matrixJoiner.join(table);
    }

    @FunctionalInterface
    public static interface MatrixJoiner<T> {
        T join(List<List<T>> matrix);
    }

    @FunctionalInterface
    public static interface VectorJoiner<T> {
        T join(List<T> vector);
    }
}
