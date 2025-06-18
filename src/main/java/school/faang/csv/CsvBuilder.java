package school.faang.csv;

import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author Danil Pudovkin
 * @since 18.06.2025
 */
@NoArgsConstructor(access = PRIVATE)
public class CsvBuilder {

    public static String toCsv(List<List<String>> table) {
        VectorJoiner<String> vectorJoiner = vectors -> {
            var sb = new StringBuilder();
            for (int i = 0; i < vectors.size(); i++) {
                sb.append(vectors.get(i));
                if (i < vectors.size() - 1) {
                    sb.append(", ");
                } else {
                    sb.append("\n");
                }
            }
            return sb.toString();
        };
        MatrixJoiner<String> matrixJoiner = matrix -> {
            var sb = new StringBuilder();
            for (var row : matrix) {
                sb.append(vectorJoiner.join(row));
            }
            return sb.toString().trim();
        };
        return matrixJoiner.join(table);
    }
}
