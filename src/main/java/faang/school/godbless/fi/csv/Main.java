package faang.school.godbless.fi.csv;

import java.util.List;
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

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        VectorJoiner<String> vectorJoiner = vector -> {
            if (vector.isEmpty()) {
                throw new IllegalArgumentException("> error: vector is empty");
            }

            return "> " + String.join(", ", vector);
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            if (matrix.isEmpty()) {
                throw new IllegalArgumentException("> error: the matrix is empty... sorry, Neo");
            }

            return matrix
                    .stream()
                    .map(x -> vectorJoiner.join(x) + "\n")
                    .collect(Collectors.joining());
        };

        return matrixJoiner.join(table);
    }

}
