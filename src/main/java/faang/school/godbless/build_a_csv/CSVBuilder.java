package faang.school.godbless.build_a_csv;

import java.util.List;
import java.util.stream.Collectors;

public class CSVBuilder {

    public String toCsv(List<List<String>> table) throws IllegalArgumentException {

         VectorJoiner<String> vectorJoiner = (List<String> vector) -> String.join(", ", vector);
         MatrixJoiner<String> matrixJoiner = (List<List<String>> matrix) -> matrix.stream()
                .map(vectorJoiner::join)
                .collect(Collectors.joining("\n"));

        return matrixJoiner.join(table);
    }
}
