package faang.school.godbless.create_csv;

import java.util.List;

public class CsvCreator {
    public static String toCsv(List<List<String>> table) {
        VectorJoiner<String> vectorJoiner = vector -> {
            if (vector.isEmpty()) {
                throw new IllegalArgumentException("Empty list");
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
                throw new IllegalArgumentException("Empty list");
            }

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < matrix.size(); ++i) {
                builder.append(vectorJoiner.join(matrix.get(i)) + "\n");
            }
            return builder.toString();
        };
        return matrixJoiner.join(table);
    }
}
