package sprint3.lambda.csv;

import sprint3.lambda.csv.joiner.MatrixJoiner;
import sprint3.lambda.csv.joiner.VectorJoiner;

import java.util.List;
import java.util.stream.Collectors;

public class CSVHandler {
    private final static String SEPARATOR = ", ";
    private final static String NEW_LINE = "\n";

    public static String toCsv(List<List<String>> table) {
        if (table.isEmpty()) {
            throw new IllegalArgumentException("Was got empty list");
        }
        VectorJoiner<String> vector = (list) -> list.stream().
                map(String::toString).
                collect(Collectors.joining(SEPARATOR));

        MatrixJoiner<String> matrix = (list) -> list.stream()
                .map(vector::join)
                .collect(Collectors.joining(NEW_LINE));
        return matrix.join(table);
    }
}
