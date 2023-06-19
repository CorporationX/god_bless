package sprint3.csv;

import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
public interface MatrixJoiner<T> {
    T join(List<List<T>> matrix);

    static String toCsv(List<List<String>> matrix) {
        MatrixJoiner<String> joiner = (m) -> {
            if (matrix.isEmpty()) {
                throw new IllegalArgumentException("Empty list");
            }
            return matrix.stream()
                    .map(VectorJoiner::toCsv)
                    .collect(Collectors.joining("\n"));
        };
        return joiner.join(matrix);
    }
}
