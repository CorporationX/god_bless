package LambdaStream.bc1549;

import java.util.List;
import java.util.stream.Collectors;

public class CSV {

    static VectorJoiner<String> vectorJoiner = vector -> {
        if (vector.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        return String.join(", ", vector);
    };

    static MatrixJoiner<String> matrixJoiner = matrix -> {
        if (matrix.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        return matrix.stream().map(list -> vectorJoiner.join(list) + "\n").collect(Collectors.joining());
    };

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {

        return matrixJoiner.join(table);
    }


}
