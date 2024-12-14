package school.faang.task_46490;

import java.util.List;
import java.util.stream.Collectors;

public class TwoDimensionArrayToCsv {
    public static String toCsv(List<List<String>> table) {
        VectorJoiner<String> vectorJoiner = vector -> String.join(", ", vector);
        MatrixJoiner<String> matrixJoiner = matrix -> matrix.stream()
                .map(vectorJoiner::join)
                .collect(Collectors.joining("\n")) + "\n";
        return matrixJoiner.join(table);
    }
}
