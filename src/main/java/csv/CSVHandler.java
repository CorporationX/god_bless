package csv;

import csv.joiner.MatrixJoiner;
import csv.joiner.VectorJoiner;

import java.util.List;
import java.util.stream.Collectors;

public class CSVHandler {
    private final static String SEPARATOR = ", ";

    public static String toCsv(List<List<String>> table) {
        if (table.isEmpty()) {
            throw new IllegalArgumentException();
        }
        VectorJoiner<String> vector = (list) -> list.stream().
                map(String::toString).
                collect(Collectors.joining(SEPARATOR));

        MatrixJoiner<String> matrix = (list) -> list.stream()
                .map(vector::join)
                .collect(Collectors.joining("\n"));
        return matrix.join(table);
    }
}
