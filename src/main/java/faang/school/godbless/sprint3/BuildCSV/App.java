package faang.school.godbless.sprint3.BuildCSV;

import faang.school.godbless.sprint3.BuildCSV.interfaces.MatrixJoiner;
import faang.school.godbless.sprint3.BuildCSV.interfaces.VectorJoiner;

import java.util.List;

public class App {
    public final static String LIST_IS_EMPTY_ERROR_MESSAGE = "List is null";
    public final static String LIST_IS_NULL_ERROR_MESSAGE = "List is null";
    public static String toCsv(List<List<String>> table) throws IllegalArgumentException{
        VectorJoiner<String> vectorJoiner = vector -> {
            if (vector == null) {
                throw new IllegalArgumentException(LIST_IS_NULL_ERROR_MESSAGE);
            }
            if (vector.isEmpty()) {
                throw new IllegalArgumentException(LIST_IS_EMPTY_ERROR_MESSAGE);
            }
            StringBuilder builder = new StringBuilder();
            builder.append(vector.get(0));
            for (int i = 1; i < vector.size(); i++){
                builder.append(", ")
                        .append(vector.get(i));
            }
            return builder.toString();
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            if (matrix == null) {
                throw new IllegalArgumentException(LIST_IS_NULL_ERROR_MESSAGE);
            }
            if (matrix.isEmpty()) {
                throw new IllegalArgumentException(LIST_IS_EMPTY_ERROR_MESSAGE);
            }
            StringBuilder builder = new StringBuilder();
            builder.append(vectorJoiner.join(matrix.get(0)));
            for (int i = 1; i < matrix.size(); i++){
                builder.append("\n").append(vectorJoiner.join(matrix.get(i)));
            }
            return builder.toString();
        };
        return matrixJoiner.join(table);
    }
}
