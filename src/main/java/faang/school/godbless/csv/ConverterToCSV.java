package faang.school.godbless.csv;

import java.util.List;

public class ConverterToCSV {
    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        VectorJoiner<String> vectorJoiner = (row) -> {
            if (row.isEmpty()) {
                throw new IllegalArgumentException("Empty list");
            }
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(row.get(0));
            for (int i = 1; i < row.size(); i++) {
                stringBuilder.append(", ");
                stringBuilder.append(row.get(i));
            }
            return stringBuilder.toString();
        };

        MatrixJoiner<String> matrixJoiner = (matrix) -> {
            if (matrix.isEmpty()) {
                throw new IllegalArgumentException("Empty matrix");
            }
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(vectorJoiner.join(table.get(0)));
            for (int i = 1; i < table.size(); i++) {
                stringBuilder.append("\n");
                stringBuilder.append(vectorJoiner.join(table.get(i)));
            }
            return stringBuilder.toString();
        };

        return matrixJoiner.join(table);
    }
}
