package school.faang.BJS2_34267_BuildingCsv;

import java.util.List;
import java.util.stream.Collectors;

public class CsvBuilder {
    public static String toCsv(List<List<String>> table) {
        VectorJoiner<String> vectorJoiner = vector -> String.join(", ", vector);
        MatrixJoiner<String> matrixJoiner = matrix ->
                matrix.stream()
                .map(vectorJoiner::join)
                        .collect(Collectors.joining("\n"));
        return matrixJoiner.join(table);
    }
}
