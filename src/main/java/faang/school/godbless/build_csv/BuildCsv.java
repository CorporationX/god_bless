package faang.school.godbless.build_csv;

import java.util.List;

public class BuildCsv {

    private static final VectorJoiner<String> stringFromList = vector -> {
        if (vector.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }
        StringBuilder builder = new StringBuilder();
        builder.append(vector.get(0));
        for (int i = 1; i < vector.size(); ++i) {
            builder.append(", ");
            builder.append(vector.get(i));
        }
        return builder.toString();
    };

    private static final MatrixJoiner<String> stringFromMatrix = matrix -> {
        if (matrix.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }
        StringBuilder builder = new StringBuilder();
        for (List<String> strings : matrix) {
            String line = stringFromList.join(strings);
            builder.append(line).append("\n");
        }
        return builder.toString();
    };


    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        return stringFromMatrix.join(table);
    }
}
