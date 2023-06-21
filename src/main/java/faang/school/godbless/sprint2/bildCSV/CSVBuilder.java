package faang.school.godbless.sprint2.bildCSV;

import java.util.List;
import java.util.stream.Collectors;

public class CSVBuilder {
    private static final String SEPARATOR = ", ";
    private static final String NEW_LINE = "\n";

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        if (table == null || table.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty");
        }

        VectorJoiner<String> vectorJoiner = vector -> vector.stream()
                .map(String::toString)
                .collect(Collectors.joining(SEPARATOR));

        MatrixJoiner<String> matrixJoiner = matrix -> matrix.stream()
                .map(vectorJoiner::join)
                .collect(Collectors.joining(NEW_LINE));

        return matrixJoiner.join(table);
    }
}
