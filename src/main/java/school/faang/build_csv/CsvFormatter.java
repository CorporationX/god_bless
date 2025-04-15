package school.faang.build_csv;

import java.util.List;
import java.util.stream.Collectors;

public class CsvFormatter {
    private static final VectorJoiner<String> vectorJoiner = list -> String.join(",", list);

    private static final MatrixJoiner<String> matrixJoiner = list ->
            list.stream().map(vectorJoiner::join).collect(Collectors.joining("\n"));

    public static String toCsv(List<List<String>> table) {
        return matrixJoiner.join(table);
    }
}
