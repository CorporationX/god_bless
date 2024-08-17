package csv.build;

import lombok.NonNull;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var result = toCsv(
                List.of(
                        List.of("1", "2", "3", "4", "5"),
                        List.of("6", "7", "8", "9", "10"),
                        List.of("11", "12", "13", "14", "15"),
                        List.of("16", "17", "18", "19", "20"),
                        List.of("21", "22", "23", "24", "25")
                )
        );
        System.out.println(result);
    }

    public static String toCsv(@NonNull List<List<String>> table) throws IllegalArgumentException {
        validateMatrix(table);
        VectorJoiner<String> vectorJoiner = (vector) -> String.join(", ", vector);
        MatrixJoiner<String> matrixJoiner = (matrix) -> matrix.stream()
                .map(vectorJoiner::join)
                .collect(Collectors.joining("\n"));

        return matrixJoiner.join(table);
    }

    private static void validateMatrix(@NonNull List<List<String>> table) {
        if (table.isEmpty()) {
            throw new IllegalArgumentException("Matrix is empty");
        }
        if (table.stream()
                .anyMatch(Objects::isNull)) {
            throw new NullPointerException("Row of the matrix is null");
        }
        if (table.stream()
                .anyMatch(List::isEmpty)) {
            throw new IllegalArgumentException("Row of the matrix is empty");
        }
    }
}
