package school.faang.buildcsv;

import lombok.NoArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class CsvConverter {

    public static String toCsv(List<List<String>> table) {

        VectorJoiner<String> vectorJoiner = (vector) -> String.join(", ", vector);

        MatrixJoiner<String> matrixJoiner = (matrix) -> matrix.stream()
                .map(vectorJoiner::join)
                .collect(Collectors.joining("\n"));

        // Apply MatrixJoiner to create the final CSV string
        return matrixJoiner.join(table);
    }
}