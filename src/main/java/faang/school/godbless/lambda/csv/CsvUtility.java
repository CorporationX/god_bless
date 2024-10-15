package faang.school.godbless.lambda.csv;

import java.util.List;
import java.util.stream.Collectors;

public class CsvUtility {
    private CsvUtility() {
    }

    private static final VectorJoiner<String> vectorJoiner = v -> String.join(", ", v);
    private static final MatrixJoiner<String> matrixJoiner = m -> m.stream()
            .map(vectorJoiner::join)
            .collect(Collectors.joining(String.format(",%n")));

    public static String toCsv(List<List<String>> table) {
        return matrixJoiner.join(table);
    }
}
