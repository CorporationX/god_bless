package faang.school.godbless.buildCSV;

import faang.school.godbless.buildCSV.interfaceCSV.MatrixJoiner;
import faang.school.godbless.buildCSV.interfaceCSV.VectorJoiner;

import java.util.List;

public class BuildCSV {

    private static final VectorJoiner<String> vectorJoiner = list -> {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }
        StringBuilder strings = new StringBuilder();
        list.forEach(element -> strings.append(element).append(',').append(" "));
        return strings.substring(0, strings.length() - 2);
    };

    private static final MatrixJoiner<String> matrixJoiner = list -> {
        StringBuilder builder = new StringBuilder();
        list.stream().map(vectorJoiner::join).forEach(string -> builder.append(string).append("\n"));
        return builder.toString();
    };


    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        if (table.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }
        return matrixJoiner.join(table);
    }
}
