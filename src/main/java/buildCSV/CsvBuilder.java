package buildCSV;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class CsvBuilder {
    private static final String SEPARATOR = ", ";
    private static final String NEXT_LINE = "\n";

    public static String toCsv(@NotNull List<List<String>> table) throws IllegalArgumentException {
        if (table.isEmpty()) {
            throw new IllegalArgumentException("Error, input data is empty");
        }
        VectorJoiner<String> vector = (list) -> list.stream()
                .map(String::toString)
                .collect(Collectors.joining(SEPARATOR));

        MatrixJoiner<String> matrix = (list) -> list.stream()
                .map(vector::join)
                .collect(Collectors.joining(NEXT_LINE));
        return matrix.join(table);
    }
}
