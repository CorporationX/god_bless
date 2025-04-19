package school.faang.BJS2_70248;

import java.util.List;
import java.util.stream.Collectors;

public class Formatter {

    public static <T> String toCsv(List<List<T>> table) {
        VectorJoiner<T> vectorJoiner = vector -> vector.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        MatrixJoiner<T> matrixJoiner = matrix -> matrix.stream()
                .map(vectorJoiner::join)
                .collect(Collectors.joining("\n"));
        return matrixJoiner.join(table);
    }
}
