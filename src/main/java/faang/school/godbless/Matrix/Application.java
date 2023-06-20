package faang.school.godbless.Matrix;
import faang.school.godbless.Calculator.Calculator;

import java.util.List;

public class Application {
    public static void main(String... args) {

    }
    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        if (table.isEmpty()) {
            throw new IllegalArgumentException("Table is empty");
        }
        VectorJoiner<String> vectorJoiner = vector -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(vector.get(0));
            for (int i = 1; i < vector.size(); i++) {
                stringBuilder.append(", ").append(vector.get(i));
            }
            return stringBuilder.toString();
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            StringBuilder res = new StringBuilder(vectorJoiner.join(matrix.get(0)));
            for (int i = 1; i < matrix.size(); i++) {
                res.append("\n").append(vectorJoiner.join(matrix.get(i)));
            }
            return res.toString();
        };

        return matrixJoiner.join(table);

    }
}
