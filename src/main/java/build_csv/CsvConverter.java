package build_csv;

import java.util.List;
import java.util.stream.Collectors;

public class CsvConverter {

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        if (table == null || table.isEmpty()) {
            throw new IllegalArgumentException("Table cannot be null or empty.");
        }

        VectorJoiner<String> vectorJoiner = vector -> {
            if (vector.isEmpty()) {
                throw new IllegalArgumentException("Empty list");
            }

            return vector.stream().collect(Collectors.joining(", "));
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            if (matrix.isEmpty()) {
                throw new IllegalArgumentException("Empty matrix");
            }

            return matrix.stream().map(vectorJoiner::join).collect(Collectors.joining("\n"));
        };

        return matrixJoiner.join(table);
    }

    public static void main(String[] args) {
        List<List<String>> table = List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25")
        );

        String csv = toCsv(table);
        System.out.println(csv);
    }
}

