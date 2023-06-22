package Build_CSV;

import java.util.List;

public class BuildCSV {
    private static VectorJoiner<String> strFromList = vector -> {
        if (vector.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }
        StringBuilder builder = new StringBuilder();
        builder.append(vector.get(0));
        for (int i = 1; i < vector.size(); ++i) {
            builder.append(", ");
            builder.append(vector.get(i));
        }
        return builder.toString();
    };

    private static MatrixJoiner<String> strFromMatrix = matrix -> {
        if (matrix.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < matrix.size(); ++i){
            String line = strFromList.join(matrix.get(i));
            builder.append(line).append("\n");
        }
        return builder.toString();
    };

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        return strFromMatrix.join(table);
    }
}
