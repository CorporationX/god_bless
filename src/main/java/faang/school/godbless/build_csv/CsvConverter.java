package faang.school.godbless.build_csv;

import java.util.List;

public class CsvConverter {
    public String toCsv(List<List<String>> table) throws IllegalArgumentException {
        VectorJoiner<String> vectorJoiner = vector -> {
            if (vector.isEmpty()) {
                throw new IllegalArgumentException("Лист пуст");
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
                throw new IllegalArgumentException("Матрица пуста");
            }
            StringBuilder builder = new StringBuilder();
            for (List<String> row : matrix) {
                builder.append(vectorJoiner.join(row));
                builder.append("\n");
            }
            return builder.toString();
        };
        return matrixJoiner.join(table);
    }
}