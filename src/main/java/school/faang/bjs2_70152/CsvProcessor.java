package school.faang.bjs2_70152;

import java.util.List;

public class CsvProcessor {
    private static final VectorJoiner<String> VECTOR_JOINER = list -> list.stream()
            .reduce((a, b) -> String.format("%s, %s", a, b))
            .get();
    private static final MatrixJoiner<String> MATRIX_JOINER = list -> list.stream()
            .map(VECTOR_JOINER::join)
            .reduce((a, b) -> String.format("%s%n%s", a, b))
            .get();

    public static String toCsv(List<List<String>> table) {
        validateList(table);
        table.forEach(CsvProcessor::validateList);
        return MATRIX_JOINER.join(table);
    }

    private static void validateList(List<?> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
    }
}