package faang.school.godbless.lamdbastreamapi.csv;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String CSV_DELIMIER = ",";
    public static void main(String[] args) {

        String result = toCsv(
                List.of(
                        List.of("1", "2", "3", "4", "5"),
                        List.of("6", "7", "8", "9", "10"),
                        List.of("11", "12", "13", "14", "15"),
                        List.of("16", "17", "18", "19", "20"),
                        List.of("21", "22", "23", "24", "25")
                )
        );
        System.out.println(result);
    }

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        VectorJoiner<String> vectorJoiner = (vector) -> String.join(CSV_DELIMIER, vector);
        MatrixJoiner<String> matrixJoiner = (matrix) -> {
            List<String> rows = new ArrayList<>();
            for (List<String> row : matrix) {
                rows.add(vectorJoiner.join(row));
            }
            return String.join("\n", rows);
        };

        return matrixJoiner.join(table);
    }
}
