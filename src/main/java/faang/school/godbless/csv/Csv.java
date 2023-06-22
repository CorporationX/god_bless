package faang.school.godbless.csv;

import lombok.NonNull;

import java.util.List;
import java.util.Objects;

public class Csv {
    public static String toCsv(@NonNull List<List<String>> table) {
        VectorJoiner<String> vectorJoiner = vector -> {
            return String.join(", ", vector);
        };
        MatrixJoiner<String> matrixJoiner =
                matrix -> String.join(",\n", matrix.stream()
                        .filter(Objects::nonNull)
                        .map(vectorJoiner::join).toList());
        return matrixJoiner.join(table);
    }
}
