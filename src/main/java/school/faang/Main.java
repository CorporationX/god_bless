package school.faang;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        VectorJoiner<String> vectorJoiner = vector -> {
            if (vector == null || vector.isEmpty()) {
                throw new IllegalArgumentException("Vector can't be null or empty.");
            }
            return vector.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));

        };

        MatrixJoiner<String> matrixJoiner = vector -> {
            if (vector == null || vector.isEmpty()) {
                throw new IllegalArgumentException("Vector can't be null or empty.");
            }
            return vector.stream()
                    .map(vectorJoiner::join)
                    .collect(Collectors.joining("\n"));
        };
        List<List<String>> toCsv = (
                List.of(
                        List.of("1", "2", "3", "4", "5"),
                        List.of("6", "7", "8", "9", "10"),
                        List.of("11", "12", "13", "14", "15"),
                        List.of("16", "17", "18", "19", "20"),
                        List.of("21", "22", "23", "24", "25")
                )
        );
        System.out.println(matrixJoiner.join(toCsv));
    }
}
