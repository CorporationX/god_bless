package faang.school.godbless.BJS2_21598;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        if (table == null || table.isEmpty() ||
        table.stream().anyMatch(List::isEmpty)
                || table.stream().flatMap(Collection::stream).anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException("Table cannot be null or empty and" +
                    "must not contain null or empty rows");
        }

        VectorJoiner<String> vectorJoiner = vector -> String.join(",", vector);

        MatrixJoiner<String> matrixJoiner = matrix -> matrix.stream().
                map(vectorJoiner::join).collect(Collectors.joining("\n"));

        return matrixJoiner.join(table);
    }

    public static void main(String[] args) {

        String test = toCsv(
                List.of(
                        List.of("1", "2", "3", "4", "5"),
                        List.of("6", "7", "8", "9", "10"),
                        List.of("11", "12", "13", "14", "15"),
                        List.of("16", "17", "18", "19", "20"),
                        List.of("21", "22", "23", "24", "25")
                )
        );

        System.out.println(test);
    }
}
