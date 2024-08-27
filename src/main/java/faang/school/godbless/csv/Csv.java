package faang.school.godbless.csv;

import java.util.List;

public class Csv {
    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        if (table == null) {
            throw new IllegalArgumentException("table is null");
        }

        VectorJoiner<String> vectorJoiner = (vector) -> String.join(", ", vector);
        MatrixJoiner<String> matrixJoiner = (matrix) -> String.join("\n", matrix.stream().map(vectorJoiner::join).toList());

        return matrixJoiner.join(table);
    }
}
