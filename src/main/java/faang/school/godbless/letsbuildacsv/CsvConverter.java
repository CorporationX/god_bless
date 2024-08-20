package faang.school.godbless.letsbuildacsv;

import java.util.List;
import java.util.stream.Collectors;

public class CsvConverter {
    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        if (table == null || table.isEmpty()) {
            throw new IllegalArgumentException("Table cannot be null or empty");
        }

        VectorJoiner<String> vectorJoiner = vector -> String.join(", ", vector);

        MatrixJoiner<String> matrixJoiner = matrix ->
                matrix.stream()
                        .map(vectorJoiner::join)
                        .collect(Collectors.joining("\n"));

        return matrixJoiner.join(table);
    }
}