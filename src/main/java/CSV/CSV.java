package CSV;

import java.util.List;

public class CSV {
    public static String toCSV(List<List<String>> table) throws IllegalArgumentException {

        VectorJoiner<String> vectorJoiner = vector -> {
            if (table == null || table.isEmpty()) {
                throw new IllegalArgumentException("List is empty");
            }

            StringBuilder builder = new StringBuilder();
            builder.append(vector.get(0));

            for (int i = 1; i < vector.size(); i++) {
                builder.append(", ");
                builder.append(vector.get(i));
            }
            return builder.toString();
        };
        MatrixJoiner<String> matrixJoiner = matrix -> {
            if (table == null || table.isEmpty()) {
                throw new IllegalArgumentException("List is empty");
            }

            StringBuilder builder = new StringBuilder();
            builder.append(matrix.get(0));

            for (int i = 1; i < matrix.size(); i++) {
                String str = vectorJoiner.join(matrix.get(i));
                builder.append("\n").append(str);
            }
            return builder.toString();
        };
        return matrixJoiner.join(table);
    }
}
