package Sprint_2.BJS2_34296;

import java.util.List;
import java.util.StringJoiner;

public class CsvConverter {
    public static String toCsv(List<List<String>> table) {
        VectorJoiner<String> vectorJoiner = vector -> {
            StringJoiner joiner = new StringJoiner(",");
            for (String element : vector) {
                joiner.add(element);
            }
            return joiner.toString();
        };

        MatrixJoiner <String> matrixJoiner = matrix -> {
            StringJoiner joiner = new StringJoiner("\n");
            for (List<String> row : matrix) {
                joiner.add(vectorJoiner.join(row));
            }
            return joiner.toString();
        };
return matrixJoiner.join(table);
    }

}