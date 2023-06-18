package faang.school.godbless.sprint3.task2;

import java.util.List;

public class CSV {

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        if (table.isEmpty()) {
            throw new IllegalArgumentException();
        }

        VectorJoiner<String> vectorJoiner = vector -> String.join(", ", vector);

        MatrixJoiner<String> matrixJoiner = matrix -> {
            StringBuilder sb = new StringBuilder();
            for (List<String> vector : matrix) {
                String join = vectorJoiner.join(vector);
                sb.append(join).append("\n");
            }
            return sb.toString().trim();
        };

        return matrixJoiner.join(table);
    }

}
