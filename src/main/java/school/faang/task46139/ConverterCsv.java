package school.faang.task46139;

import java.util.List;
import java.util.Objects;

public class ConverterCsv {
    public static String toCsv(List<List<String>> table) {
        if (table == null) {
            throw new IllegalArgumentException("table can`t be null");
        }
        List<List<String>> newTable = table.stream().filter(Objects::nonNull).toList();
        StringBuilder result = new StringBuilder();

        VectorJoiner<String> vectorJoiner = list -> {

            list.forEach(string -> result.append(string).append(", "));

            return result
                    .delete(result.length() - 2, result.length() - 1)
                    .append("\n").toString();
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            matrix.forEach(list -> {
                if (list.isEmpty()) {
                    throw new IllegalArgumentException("List can`t be null");
                }
                vectorJoiner.join(list.stream()
                        .filter(Objects::nonNull)
                        .toList());
            });
            return result.toString();
        };

        return matrixJoiner.join(newTable);

    }
}
