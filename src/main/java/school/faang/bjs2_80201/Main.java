package school.faang.bjs2_80201;

import java.util.List;

public class Main {
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

    public static String toCsv(List<List<String>> table) {
        VectorJoiner<String> vectorJoiner = (vector) -> {
            if (vector.isEmpty()) {
                throw new IllegalArgumentException("List is empty");
            }
            return String.join(", ", vector);
        };
        MatrixJoiner<String> matrixJoiner = matrix -> {
            StringBuilder builder = new StringBuilder();
            matrix.forEach(vector -> {
                builder.append(vectorJoiner.join(vector)).append("\n");
            });
            return builder.toString();
        };
        return matrixJoiner.join(table);
    }
}
