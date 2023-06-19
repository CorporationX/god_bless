package buildCSV;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class buildCSV {
    public static final String SEPARATOR = ", ";

    public static String toCsv(@NotNull List<List<String>> table) throws IllegalArgumentException {
        if (table.isEmpty()) {
            throw new IllegalArgumentException("Error, input data is empty");
        }
        VectorJoiner<String> vector = (list) -> list.stream()
                .map(String::toString)
                .collect(Collectors.joining(SEPARATOR));

        MatrixJoiner<String> matrix = (list) -> {
            StringJoiner joiner = new StringJoiner("\n");
            for (List<String> strings : list) {
                String join = vector.join(strings);
                joiner.add(join);
            }
            return joiner.toString();
        };
        return  matrix.join(table);
    }
}
