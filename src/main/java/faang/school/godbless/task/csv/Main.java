package faang.school.godbless.task.csv;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        if (table == null) {
            throw new IllegalArgumentException("table is null");
        }

        VectorJoiner<String> vectorJoiner = list -> String.join(", ", list).trim();

        MatrixJoiner<String> matrixJoiner = matrix -> matrix.stream()
                .filter(Objects::nonNull)
                .map(vectorJoiner::join)
                .filter(str -> !str.isEmpty())
                .collect(Collectors.joining("\n"));

        return matrixJoiner.join(table).trim();
    }

    public static void main(String[] args) {
    }
}
