package school.faang.task_46142;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CsvConverter {
    private static final String SEPARATOR = ", ";
    private static final String NEW_LINE = "\n";
    private static final String ERROR_MESSAGE = "Некорретное значение входного параметра!";

    public static String toCsv(List<List<String>> table) {
        if (table == null || table.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        MatrixJoiner<String> matrixJoiner = getMatrixJoiner();
        return matrixJoiner.join(table);
    }

    private static MatrixJoiner<String> getMatrixJoiner() {
        return matrix -> {
            StringBuilder result = new StringBuilder();
            result.append(NEW_LINE);

            for (int i = 0; i < matrix.size(); i++) {
                VectorJoiner<String> vectorJoiner = getVectorJoiner();
                String line = vectorJoiner.join(matrix.get(i));

                if (i == matrix.size() - 1) {
                    result.append(line);
                } else {
                    result.append(line).append(NEW_LINE);
                }
            }
            return result.toString();
        };
    }

    private static VectorJoiner<String> getVectorJoiner() {
        return vector -> {
            if (vector == null || vector.isEmpty()) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }

            StringBuilder line = new StringBuilder();

            for (int i = 0; i < vector.size(); i++) {
                String element = vector.get(i);

                if (i == vector.size() - 1) {
                    line.append(element);
                } else {
                    line.append(element).append(SEPARATOR);
                }
            }
            return line.toString();
        };
    }
}
