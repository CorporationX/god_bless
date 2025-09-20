package school.faang.bjs2_88858;

import java.util.List;

public class CsvConverter {

    public static String toCsv(List<List<String>> table) {
        VectorJoiner<String> vectorJoiner = list -> String.join(", ", list);

        MatrixJoiner<String> matrixJoiner =
                matrix -> String.join("\n", matrix.stream()
                        .map(vectorJoiner::join)
                        .toList());

        return matrixJoiner.join(table);
    }
}
