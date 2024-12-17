package school.faang.sprint_2.task_bjs246143;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static final String CSV_DELIMITER = ", ";
    private static final VectorJoiner<String> STRINGS_VECTOR_JOINER = vector -> {
        if (vector == null || vector.isEmpty()) {
            throw new IllegalArgumentException("Null or empty vector");
        }
        return String.join(CSV_DELIMITER, vector);
    };
    private static final MatrixJoiner<String> STRINGS_MATRIX_JOINER = matrix -> {
        if (matrix == null || matrix.isEmpty()) {
            throw new IllegalArgumentException("Null or empty matrix");
        }
        return matrix.stream()
                .map(STRINGS_VECTOR_JOINER::join)
                .collect(Collectors.joining("\n"));
    };

    private static final VectorJoiner<Integer> INTEGERS_VECTOR_JOINER = vector -> {
        if (vector == null || vector.isEmpty()) {
            throw new IllegalArgumentException("Null or empty vector");
        }
        return vector.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(CSV_DELIMITER));
    };
    private static final MatrixJoiner<Integer> INTEGERS_MATRIX_JOINER = matrix -> {
        if (matrix == null || matrix.isEmpty()) {
            throw new IllegalArgumentException("Null or empty matrix");
        }
        return matrix.stream()
                .map(INTEGERS_VECTOR_JOINER::join)
                .collect(Collectors.joining("\n"));
    };

    public static void main(String[] args) {

        List<List<String>> tableOfStrings = List.of(
                List.of("Вася", "Владимир", "Владислав", "Владлен", "Валдис"),
                List.of("Анатолий", "Афанасий", "Акакий", "Александр", "Алексей"),
                List.of("Геннадий", "Георгий", "Герасим", "Герман", "Глеб")
        );
        System.out.println("-----Table of strings-----\n: " + tableOfStrings);
        System.out.println("CSV from table of strings:\n" + toCsv(tableOfStrings, STRINGS_MATRIX_JOINER));

        List<List<Integer>> tableOfIntegers = List.of(
                List.of(1, 2, 3, 4, 5),
                List.of(6, 7, 8, 9, 10),
                List.of(11, 12, 13, 14, 15)
        );
        System.out.println("-----Table of integers-----\n: " + tableOfIntegers);
        System.out.println("CSV from table of integers:\n" + toCsv(tableOfIntegers, INTEGERS_MATRIX_JOINER));

    }

    public static <T> String toCsv(List<List<T>> table, MatrixJoiner<T> joiner) {
        return joiner.join(table);
    }
}
