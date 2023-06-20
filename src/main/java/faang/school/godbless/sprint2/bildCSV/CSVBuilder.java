package faang.school.godbless.sprint2.bildCSV;

import java.util.List;
import java.util.stream.Collectors;

public class CSVBuilder {
    private final static String separator = ", ";
    private final static String newLine = "\n";
    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        if(table.isEmpty()){
            throw new IllegalArgumentException("Лист не может быть пустым");
        }

        VectorJoiner<String> vectorJoiner = vector -> vector.stream()
                .map(String::toString)
                .collect(Collectors.joining(separator));

        MatrixJoiner<String> matrixJoiner = matrix -> matrix.stream()
                .map(vectorJoiner::join)
                .collect(Collectors.joining(newLine));

        return matrixJoiner.join(table);
    }
}
