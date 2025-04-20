package school.faang.BJS2_70248;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Formatter {

    public static <T> String toCsv(List<List<T>> table) {
        if (table == null) {
            throw new IllegalArgumentException("Input data cannot be null");
        }
        VectorJoiner<T> vectorJoiner = vector -> vector.stream()
                .filter(Objects::nonNull)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        MatrixJoiner<T> matrixJoiner = matrix -> matrix.stream()
                .filter(Objects::nonNull)
                .map(vectorJoiner::join)
                .collect(Collectors.joining("\n"));
        return matrixJoiner.join(table);
    }
}
