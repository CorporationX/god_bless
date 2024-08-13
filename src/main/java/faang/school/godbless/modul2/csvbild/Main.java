package faang.school.godbless.modul2.csvbild;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String table = toCsv(
                List.of(
                        List.of("1", "2", "3", "4", "5"),
                        List.of("6", "7", "8", "9", "10"),
                        List.of("11", "12", "13", "14", "15"),
                        List.of("16", "17", "18", "19", "20"),
                        List.of("21", "22", "23", "24", "25")
                )
        );
        System.out.println(table);

        try {
            toCsv(List.of());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String toCsv(List<List<String>> table) {
        if (table == null || table.isEmpty()) {
            throw new IllegalArgumentException("Param can't be null or empty");
        }

        VectorJoiner<String> vectorJoiner = row -> String.join(", ", row) + "\n";

        MatrixJoiner<String> matrixJoiner = matrix ->
                matrix.stream().map(vectorJoiner::join).collect(Collectors.joining(""));

        return matrixJoiner.join(table);
    }
}
