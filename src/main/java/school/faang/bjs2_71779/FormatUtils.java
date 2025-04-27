package school.faang.bjs2_71779;

import lombok.NonNull;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FormatUtils {
    public static String toCsv(@NonNull List<List<String>> matrix) {
        VectorJoiner<String> vectorJoiner = row ->
                row.stream()
                        .filter(Objects::nonNull)
                        .map(Object::toString)
                        .collect(Collectors.joining(", "));

        MatrixJoiner<String> matrixJoiner = rows ->
                rows.stream()
                        .filter(Objects::nonNull)
                        .map(vectorJoiner::join)
                        .collect(Collectors.joining("\n"));

        return matrixJoiner.join(matrix);
    }
}
