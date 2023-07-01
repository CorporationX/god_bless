package faang.school.godbless.csv;

import java.util.List;

public class App {
    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        VectorJoiner<String> vectorJoiner = vector -> {
            if (vector.isEmpty()) {
                throw new IllegalArgumentException("Error: list can't be empty");
            }

            StringBuilder builder = new StringBuilder();
            builder.append(vector.get(0));
            for (int i = 1; i < vector.size(); ++i) {
                builder.append(", ");
                builder.append(vector.get(i));
            }
            return builder.toString();
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            if (matrix.isEmpty()) {
                throw new IllegalArgumentException("Error: list can't be empty");
            }

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < matrix.size(); ++i) {
                builder.append(vectorJoiner.join(matrix.get(i)));
                builder.append("\n");
            }
            return builder.toString();
        };

        try {
            return matrixJoiner.join(table);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

}

