package school.faang.bjs2_88858;

import java.util.List;

public class CsvConverter {
    private static final VectorJoiner<String> VECTOR_JOINER =
            list -> String.join(", ", list);

    private static final MatrixJoiner<String> MATRIX_JOINER =
            matrix -> String.join("\n",
                    matrix.stream()
                            .map(VECTOR_JOINER::join)
                            .toList());

    public static String toCsv(List<List<String>> table) {
        return MATRIX_JOINER.join(table);
    }
}
