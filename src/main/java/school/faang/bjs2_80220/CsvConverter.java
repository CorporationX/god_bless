package school.faang.bjs2_80220;

import java.util.List;
import java.util.stream.Collectors;

public class CsvConverter {

    public static String toCsv(List<List<String>> table) {
        VectorJoiner<String> vectorJoiner = row -> String.join(", ", row);

        MatrixJoiner<String> matrixJoiner = matrix ->
                matrix.stream()
                        .map(vectorJoiner::join)
                        .collect(Collectors.joining("\n"));

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

        System.out.println(toCsv(table));
    }
}
