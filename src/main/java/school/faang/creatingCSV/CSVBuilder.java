package school.faang.creatingCSV;

import java.util.List;

public class CSVBuilder {
    public static String toCSV(List<List<String>> contents) {
        if (contents.isEmpty()) {
            throw new IllegalArgumentException("Empty data is forbidden!");
        }
        VectorJoiner<String> innerJoiner = vector -> {
            StringBuilder builder = new StringBuilder();
            builder.append(vector.get(0));
            for (int i = 1; i < vector.size(); i++) {
                builder.append(", ");
                builder.append(vector.get(i));
            }
            return builder.toString();
        };
        MatrixJoiner<String> outerJoiner = matrix -> {
            StringBuilder builder = new StringBuilder();
            for (List<String> lines : matrix) {
                builder.append(innerJoiner.join(lines)).append("\n");
            }
            return builder.toString();
        };
        return outerJoiner.join(contents);
    }
}