package lets_build_a_csv;

import java.util.List;

public class CsvProcessor {
    /**
     * Takes a table in the form of a list of lists and returns a string in CSV format.
     *
     * The outer list represents the rows of the table, and the inner lists represent the
     * columns. Each element in the inner list is a string that will be used as the value
     * for that column in the given row.
     *
     * For example, the following table:
     * <pre>
     * [
     *     ["Name", "Age", "Occupation"],
     *     ["John Doe", "20", "Software Engineer"],
     *     ["Jane Doe", "22", "Marketing Manager"],
     *     ["Bob Smith", "30", "Accountant"]
     * ]</pre>
     * Will be converted to:
     * <pre>
     * Name, Age, Occupation
     * John Doe, 20, Software Engineer
     * Jane Doe, 22, Marketing Manager
     * Bob Smith, 30, Accountant
     * </pre>
     *
     * @param table the table to be converted
     * @return a string in CSV format
     */
    public static String toCSV(List<List<String>> table) {
        VectorJoiner<String> vector_joiner = (vector) -> {
            if (vector.isEmpty()) {
                throw new IllegalArgumentException("List cannot be empty");
            }
            StringBuilder builder = new StringBuilder();
            builder.append(vector.get(0));

            for (int i = 1; i < vector.size(); ++i) {
                builder.append(", ").append(vector.get(i));
            }
            return builder.toString();
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            if (matrix.isEmpty()) {
                throw new IllegalArgumentException("List cannot be empty");
            }

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < matrix.size(); ++i) {
                builder.append(vector_joiner.join(matrix.get(i)));
                if (i < matrix.size() - 1) {
                    builder.append("\n");
                }
            }
            return builder.toString();
        };

        return matrixJoiner.join(table);
    }
}
