package faang.school.godbless.csv;

import java.util.List;

public class Main {
    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        VectorJoiner<String> vectorJoiner = (vector) -> {
            StringBuilder sb = new StringBuilder();
            for (String string : vector) {
                sb.append(string);
                sb.append(", ");
            }
            return sb.toString();
        };

        MatrixJoiner<String> matrixJoiner = (matrix) -> {
            StringBuilder sb = new StringBuilder();
            for (List<String> strings : matrix) {
                sb.append(vectorJoiner.join(strings));
                sb.append("\n");
            }
            return sb.toString();
        };

        return matrixJoiner.join(table);
    }

    public static void main(String[] args) {
        String csv = toCsv(
                List.of(
                        List.of("1", "2", "3", "4", "5"),
                        List.of("6", "7", "8", "9", "10"),
                        List.of("11", "12", "13", "14", "15"),
                        List.of("16", "17", "18", "19", "20"),
                        List.of("21", "22", "23", "24", "25")
                )
        );
        System.out.println(csv);
    }
}
