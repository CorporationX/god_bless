package school.faang.task_46136;

import java.util.List;

public class Matrix {
    public static String toCsv(List<List<String>> table) {
        VectorJoiner<String> vectorJoiner = vector -> {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < vector.size(); i++) {

                if (i >= vector.size() - 1) {
                    stringBuilder.append(vector.get(i));
                } else {
                    stringBuilder.append(vector.get(i)).append(", ");
                }

            }

            return stringBuilder.toString();
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < matrix.size(); i++) {

                String row = vectorJoiner.join(matrix.get(i));

                if (i >= matrix.size() - 1) {
                    stringBuilder.append(row);
                } else {
                    stringBuilder.append(row).append("\n");
                }

            }

            return stringBuilder.toString();
        };

        return matrixJoiner.join(table);
    }
}
