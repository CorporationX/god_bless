package faang.school.godbless.lambda.csv;

import java.util.List;

public class CsvFormat {
    private static VectorJoiner<String> vectorJoiner = vector -> {
        if (vector.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < vector.size(); i++) {
            if (i == vector.size() - 1) {
                stringBuilder.append(vector.get(i));
            } else {
                stringBuilder.append(vector.get(i) + ", ");
            }
        }
        return stringBuilder.toString();
    };

    private static MatrixJoiner<String> matrixJoiner = vector -> {
        if (vector.isEmpty()) {
            throw new IllegalArgumentException("List of lists is empty");
        }

        StringBuilder builder = new StringBuilder();
        for (List<String> list : vector) {
            builder.append(vectorJoiner.join(list) + "\n");
        }
        return builder.toString();
    };

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        if (table.isEmpty()) {
            throw new IllegalArgumentException("List of lists is empty!");
        }

        return matrixJoiner.join(table);
    }
}
