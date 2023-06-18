package build_csv;

import java.util.List;
import java.util.stream.Collectors;

public class CsvConverter {

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        if (table == null || table.isEmpty()) {
            throw new IllegalArgumentException("Table cannot be null or empty.");
        }

        VectorJoiner<String> vectorJoiner = vector -> {
            if (vector.isEmpty()) {
                throw new IllegalArgumentException("Empty list");
            }

            return String.join(", ", vector);
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            if (matrix.isEmpty()) {
                throw new IllegalArgumentException("Empty matrix");
            }

            return matrix.stream().map(vectorJoiner::join).collect(Collectors.joining("\n"));
        };

        return matrixJoiner.join(table);
    }
}

