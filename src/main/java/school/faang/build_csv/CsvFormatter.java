package school.faang.build_csv;

import java.util.List;
import java.util.stream.Collectors;

public class CsvFormatter {
    private static final VectorJoiner<String> vectorJoiner = list -> {
        StringBuilder lineWithCommas = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            lineWithCommas.append(list.get(i));
            if (i != list.size() - 1) {
                lineWithCommas.append(",");
            }
        }
        return lineWithCommas.toString();
    };

    private static final MatrixJoiner<String> matrixJoiner = list ->
            list.stream().map(vectorJoiner::join).collect(Collectors.joining("\n"));

    public static String toCsv(List<List<String>> table) {
        return matrixJoiner.join(table);
    }
}
