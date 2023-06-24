package faang.school.godbless.csv;

import java.util.List;
import java.util.stream.Collectors;

public class CSVConverter {
    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        if (table.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }

        VectorJoiner<String> vectorJoiner = vector -> {
            if (vector.isEmpty()) {
                throw new IllegalArgumentException("Empty sublist");
            }
            return String.join(", ", vector);
        };

        MatrixJoiner<String> matrixJoiner = matrix -> matrix.stream()
            .map(vectorJoiner::join)
            .collect(Collectors.joining("\n"));

        return matrixJoiner.join(table);
    }
}
