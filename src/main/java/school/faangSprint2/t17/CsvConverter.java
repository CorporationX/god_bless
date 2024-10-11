package school.faangSprint2.t17;

import java.util.List;
import java.util.stream.Collectors;

public class CsvConverter {
    public static String toCsv(List<List<String>> table) {
        VectorJoiner<String> vectorJoiner = vector ->
                vector.stream().collect(Collectors.joining(","));

        MatrixJoiner<String> matrixJoiner = matrix ->
                matrix.stream()
                        .map(vectorJoiner::join)
                        .collect(Collectors.joining("\n"));

        return matrixJoiner.join(table);
    }
}