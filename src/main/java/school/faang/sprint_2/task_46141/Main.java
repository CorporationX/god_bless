package school.faang.sprint_2.task_46141;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(toCsv(
                List.of(
                        List.of("1", "2", "3", "4", "5"),
                        List.of("6", "7", "8", "9", "10"),
                        List.of("11", "12", "13", "14", "15"),
                        List.of("16", "17", "18", "19", "20"),
                        List.of("21", "22", "23", "24", "25")
                )
        ));

        try {
            toCsv(List.of(List.of(), List.of("6", "7", "8", "9", "10")));
        } catch (IllegalArgumentException e) {
            System.out.println("Vector illegal");
        }

        try {
            toCsv(List.of());
        } catch (IllegalArgumentException e) {
            System.out.println("Matrix illegal");
        }
    }

    public static String toCsv(List<List<String>> table) {
        VectorJoiner<String> vectorJoiner = (vector) -> {
            if (vector == null) {
                throw new IllegalArgumentException("Vector can`t be null");
            }
            if (vector.isEmpty()) {
                throw new IllegalArgumentException("Vector can`t be empty");
            }
            return String.join(", ", vector);
        };

        MatrixJoiner<String> matrixJoiner = (matrix) -> {
            if (matrix == null) {
                throw new IllegalArgumentException("Matrix can`t be null");
            }
            if (matrix.isEmpty()) {
                throw new IllegalArgumentException("Matrix can`t be empty");
            }
            return matrix.stream().map(vectorJoiner::join).collect(Collectors.joining("\n"));
        };

        return matrixJoiner.join(table);
    }
}
