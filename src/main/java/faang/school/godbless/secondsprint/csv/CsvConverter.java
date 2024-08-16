package faang.school.godbless.secondsprint.csv;

import java.util.List;
import java.util.stream.Collectors;

public class CsvConverter {
    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        if (table == null || table.isEmpty() ||
        table.stream().anyMatch(row -> row.isEmpty())
        || table.stream().flatMap(row -> row.stream()).anyMatch(el -> el.isEmpty())) {
            throw new IllegalArgumentException("Table cannot be null or empty and" +
                    "must not contain empty rows");
        }

        VectorJoiner<String> vectorJoiner = vector -> vector.stream().collect(Collectors.joining(","));

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
