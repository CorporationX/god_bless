package faang.school.godbless.sprint3.task2;

import java.util.List;

public class CSV {

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        if (table == null) {
            throw new NullPointerException("Список не может быть null!");
        }
        if (table.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть пустым!");
        }
        StringBuilder sb = new StringBuilder();
        VectorJoiner<String> vectorJoiner = vector -> String.join(", ", vector);

        MatrixJoiner<String> matrixJoiner = matrix -> {
            for (List<String> vector : matrix) {
                if (vector.isEmpty()) {
                    throw new IllegalArgumentException("Список(внутренний) не может быть пустым!");
                }

                sb.append(vectorJoiner.join(vector)).append("\n");
            }
            return sb.toString().trim();
        };

        return matrixJoiner.join(table);
    }

}
