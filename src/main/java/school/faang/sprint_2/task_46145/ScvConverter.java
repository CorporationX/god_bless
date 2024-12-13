package school.faang.sprint_2.task_46145;

import java.util.List;

public class ScvConverter {

    public static String toCsv(List<List<String>> table) {
        VectorJoiner<String> vectorJoiner = (vector) -> {
            if (vector == null || vector.isEmpty()) {
                throw new IllegalArgumentException("Empty vector");
            }

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(vector.get(0));
            for (int i = 1; i < vector.size(); i++) {
                stringBuilder.append(",");
                stringBuilder.append(vector.get(i));
            }
            return stringBuilder.toString();
        };
        MatrixJoiner<String> matrixJoiner = (matrix) -> {
            if (matrix == null || matrix.isEmpty()) {
                throw new IllegalArgumentException("Empty matrix");
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (List<String> vector : matrix) {
                stringBuilder.append(vectorJoiner.join(vector));
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        };

        return matrixJoiner.join(table);
    }
}
