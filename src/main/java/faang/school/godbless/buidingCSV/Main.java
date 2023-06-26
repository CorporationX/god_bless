package faang.school.godbless.buidingCSV;

import java.util.List;

public class Main {

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        VectorJoiner<String> vectorJoiner = vector -> {
            if (vector == null || vector.isEmpty()) {
                throw new IllegalArgumentException("Vector is empty");
            }
            StringBuilder builder = new StringBuilder();
            builder.append(vector.get(0));
            for (int i = 1; i < vector.size(); i++) {
                builder.append(", " + vector.get(i));
            }
            return builder.toString();
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            if (matrix == null || matrix.isEmpty()) {
                throw new IllegalArgumentException("Matrix is empty");
            }
            StringBuilder builder = new StringBuilder();
            builder.append(vectorJoiner.join(matrix.get(0)));
            for (int i = 1; i < matrix.size(); i++) {
                builder.append("\n" + vectorJoiner.join(matrix.get(i)));
            }
            return builder.toString();
        };
        return matrixJoiner.join(table);
    }
}
