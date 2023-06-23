package faang.school.godbless.buildCSV;

import java.util.List;

public class ToCSV {
    public static String toCSV(List<List<String>> table) throws IllegalArgumentException {
        if (table == null || table.isEmpty()) {
            throw new IllegalArgumentException("list(table) cannot be empty!");
        }
        VectorJoiner<String> vectorJoiner = vector -> {
            if (vector.isEmpty()) {
                throw new IllegalArgumentException("Empty list");
            }
            StringBuilder builder = new StringBuilder();
            builder.append(vector.get(0));
            for (int i = 1; i < vector.size(); ++i) {
                builder.append(", ").append(vector.get(i));
            }
            return builder.toString();
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            if (matrix.isEmpty()) {
                throw new IllegalArgumentException("Empty list!");
            }
            StringBuilder builder = new StringBuilder();
            builder.append(vectorJoiner.join(matrix.get(0)));
            for (int i = 1; i < matrix.size(); ++i) {
                String line = vectorJoiner.join(matrix.get(i));
                builder.append("\n").append(line);
            }
            return builder.toString();
        };
        return matrixJoiner.join(table);
    }
}
