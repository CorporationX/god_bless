package school.faang.csv;

import java.util.List;
import java.util.Objects;

public class Csv {
    public static String toCsv(List<List<String>> table) {
        VectorJoiner vectorJoiner = vector -> {
            Objects.requireNonNull(vector);

            StringBuilder sb = new StringBuilder();
            vector.forEach(elem -> {
                sb.append(elem);
                sb.append(",");
            });

            sb.lastIndexOf(",");
            sb.replace(sb.lastIndexOf(","), sb.length(), "");
            return sb.toString();
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            Objects.requireNonNull(matrix);

            StringBuilder sb = new StringBuilder();
            matrix.forEach((vector) -> {
                sb.append(vectorJoiner.join(vector));
                sb.append("\n");
            });
            sb.replace(sb.lastIndexOf("\n"), sb.length(), "");
            return sb.toString();
        };

        return matrixJoiner.join(table);
    }
}
