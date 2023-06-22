package faang.school.godbless.kxnvg.csv;

import java.util.List;

public class CsvRunner {

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        VectorJoiner<String> vectorJoiner = list -> {
            StringBuilder builder = new StringBuilder();

            builder.append(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                builder.append(", ").append(list.get(i));
            }
            return builder.toString();
        };

        MatrixJoiner<String> matrixJoiner = list -> {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < list.size(); i++) {
                builder.append(vectorJoiner.join(list.get(i))).append("\n");
            }
            return builder.toString();
        };
        return matrixJoiner.join(table);
    }
}
