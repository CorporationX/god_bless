package faang.school.godbless.buildCSV;

import faang.school.godbless.buildCSV.interfaceCSV.MatrixJoiner;
import faang.school.godbless.buildCSV.interfaceCSV.VectorJoiner;

import java.util.List;

public class BuildCSV {

    private static final VectorJoiner<String> VECTORJOINER = list -> {
        if (!(list == null) && list.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }
        StringBuilder vectors = new StringBuilder();
        list.forEach(element -> vectors.append(element).append(',').append(" "));
        return vectors.substring(0, vectors.length() - 2);
    };

    private static final MatrixJoiner<String> MATRIXJOINER = list -> {
        StringBuilder builder = new StringBuilder();
        list.stream().map(VECTORJOINER::join).forEach(string -> builder.append(string).append("\n"));
        return builder.toString();
    };

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        if (!(table == null) && table.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }
        return MATRIXJOINER.join(table);
    }
}
