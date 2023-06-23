package faang.school.godbless.csv;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String csv = toCsv(
                List.of(
                        List.of("Head 1", "Head 2", "Head 3", "Head 4", "Head 5"),
                        List.of("Data 1", "Data 1", "Data 1", "Data 1", "Data 1"),
                        List.of("Data 2", "Data 2", "Data 2", "Data 2", "Data 2"),
                        List.of("Data 3", "Data 3", "Data 3", "Data 3", "Data 3"),
                        List.of("Data 4", "Data 4", "Data 4", "Data 4", "Data 4")
                )
        );

        System.out.println(csv);
    }

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        VectorJoiner<String> vectorJoiner = vector -> {
            checkTable(vector);

            StringBuilder builder = new StringBuilder();
            for (String s : vector) {
                builder.append(s);
                builder.append(", ");
            }

            return builder.toString();
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            checkTable(matrix);

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < matrix.size(); i++) {
                builder.append(vectorJoiner.join(table.get(i)));
                builder.append("\n");
            }

            return builder.toString();
        };

        return matrixJoiner.join(table);
    }

    private static <T> void checkTable(List<T> table) {
        if (table.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }
    }
}
