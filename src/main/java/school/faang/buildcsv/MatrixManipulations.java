package school.faang.buildcsv;

import java.util.List;

public class MatrixManipulations {
    private static final VectorJoiner<String> CREATOR_LINE = line -> String.join(", ", line);
    private static final MatrixJoiner<String> CREATOR_MATRIX = matrix ->
            String.join("\n", matrix.stream().map(CREATOR_LINE::join).toList());

    public String toCsv(List<List<String>> table) {
        return CREATOR_MATRIX.join(table);
    }
}
