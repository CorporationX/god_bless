package school.faang.sprint_2.build_csv;

import java.util.List;

public class Processor {
    public static String toCsv(List<List<String>> table) {
        VectorJoiner<String> vectorJoiner = vector -> {
            if (vector.isEmpty()) {
                throw new IllegalArgumentException("Empty list");
            }

            return String.join(", ", vector);
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            if (matrix.isEmpty()) {
                throw new IllegalArgumentException("Empty list");
            }

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < matrix.size(); ++i) {
                builder.append("\n").append(vectorJoiner.join(matrix.get(i)));
            }
            return builder.toString();
        };
        return matrixJoiner.join(table);
    }
}
