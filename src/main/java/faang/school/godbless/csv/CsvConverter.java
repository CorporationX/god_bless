package faang.school.godbless.csv;

import java.util.List;
import java.util.stream.Collectors;

public class CsvConverter {

    private static VectorJoiner<String> vectorJoiner = vector -> String.join(", ", vector);

    private static MatrixJoiner<String> matrixJoiner = (matrix) -> matrix.stream().map(vectorJoiner::join).collect(Collectors.joining("\n"));

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        if (table == null || table.isEmpty()) {
            throw new IllegalArgumentException("The table cannot be null or empty.");
        }
        return matrixJoiner.join(table);
    }
}
