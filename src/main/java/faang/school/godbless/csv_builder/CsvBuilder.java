package faang.school.godbless.csv_builder;

import java.util.List;
import java.util.StringJoiner;

public class CsvBuilder {

    public String toCsv(List<List<String>> table) throws IllegalArgumentException {
        VectorJoiner<String> vectorJoiner = vector -> {
            validateListNotEmpty(vector);

            StringJoiner joinVector = new StringJoiner(", ");
            for (String s : vector) {
                joinVector.add(s);
            }

            return joinVector.toString();
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            validateListNotEmpty(matrix);

            StringJoiner joinMatrix = new StringJoiner("\n");
            for (List<String> vector : matrix) {
                joinMatrix.add(vectorJoiner.join(vector));
            }

            return joinMatrix.toString();
        };

        return matrixJoiner.join(table);
    }

    private void validateListNotEmpty(List<?> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List can't be empty");
        }
    }
}


