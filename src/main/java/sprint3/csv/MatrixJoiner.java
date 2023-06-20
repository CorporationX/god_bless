package sprint3.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
public interface MatrixJoiner<T> {
    Logger LOGGER = LoggerFactory.getLogger(MatrixJoiner.class);
    T join(List<List<T>> matrix);

    static String toCsv(List<List<String>> matrix) {
        MatrixJoiner<String> joiner = (m) -> {
            if (matrix.isEmpty()) {
                LOGGER.error("Empty list");
            }
            return matrix.stream()
                    .map(VectorJoiner::toCsv)
                    .collect(Collectors.joining("\n"));
        };
        return joiner.join(matrix);
    }
}
