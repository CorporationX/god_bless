package faang.school.godbless.sprint_3.build_csv;

import java.util.List;

public class Main {

    public static String toCsv(List<List<String>> table) {
        VectorJoiner<String> vectorJoiner = vector -> {
            if (vector.isEmpty()) {
                throw new IllegalArgumentException("This list is empty");
            }
            StringBuilder builder = new StringBuilder();
            builder.append(vector.get(0));
            for (int i = 1; i < vector.size(); i++) {
                builder.append(" ,").append(vector.get(i));
            }
            return builder.toString();
        };
        MatrixJoiner<String> matrixJoiner = matrix -> {
            if (matrix.isEmpty()) {
                throw new IllegalArgumentException("Empty list");
            }
            StringBuilder builder = new StringBuilder();
            builder.append(vectorJoiner.join(matrix.get(0)));
            for (int i = 1; i < matrix.size(); i++) {
                String stroke = vectorJoiner.join(matrix.get(i));
                builder.append("\n").append(stroke);
            }
            return builder.toString();
        };
        return matrixJoiner.join(table);
    }
}