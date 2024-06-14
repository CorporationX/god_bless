package faang.school.godbless.build_csv;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class CsvFormatter {
    public static String toCsv(List<List<String>> table) {
        BiFunction<List<String>, String, String> collector = (list, delimiter) -> {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("Cannot process null or empty list");
            }
            StringBuilder result = new StringBuilder();
            int numberOfElements = list.size();
            for (int i = 0; i < numberOfElements; i++) {
                result.append(list.get(i));
                if (i != numberOfElements - 1) {
                    result.append(delimiter);
                }
            }
            return result.toString();
        };

        VectorJoiner<String> vectorJoiner = (row) -> collector.apply(row, ", ");

        MatrixJoiner<String> matrixJoiner = (rows) ->
                collector.apply(
                        rows.stream()
                                .map(vectorJoiner::join)
                                .collect(Collectors.toList()),
                        "\n");

        return matrixJoiner.join(table);
    }
}
