package faang.school.godbless;

import java.util.List;

public class Formatter {
    public String toCsv(List<List<String>> table) throws IllegalAccessException {
        VectorJoiner<String> rowJoiner = vector -> String.join(", ", vector);
        MatrixJoiner<String> matrixJoiner = matrix -> {
            StringBuilder string = new StringBuilder();
            for (var i : matrix) {
                string.append(rowJoiner.join(i));
                string.append("\n");
            }
            return string.toString();
        };
        return matrixJoiner.join(table);
    }
}
