package school.faang.task46139;

import java.util.List;
import java.util.stream.Collectors;

public class ConverterCsv {
    private static final String SWITCHING_TO_NEW_LINE = "\n";
    private static final String COMMA_SEPARATOR_WITH_SPACE = ", ";

    public static String toCsv(List<List<String>> table) {
        if (table == null) {
            throw new IllegalArgumentException("table can`t be null");
        }
        StringBuilder result = new StringBuilder();

        VectorJoiner<String> vectorJoiner = list -> {

            result.append(list.stream().collect(Collectors.joining(COMMA_SEPARATOR_WITH_SPACE)));

            return result
                    .append(SWITCHING_TO_NEW_LINE)
                    .toString();
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            matrix.forEach(list -> {
                if (list.isEmpty()) {
                    throw new IllegalArgumentException("List can`t be null");
                }
                vectorJoiner.join(list);
            });
            return result.toString();
        };

        return matrixJoiner.join(table);

    }
}
