package faang.school.godbless;

import org.w3c.dom.ls.LSOutput;

import java.util.List;

public class Application {
    public static void main(String... args) {
        System.out.println(Application.toCsv(
                List.of(
                        List.of("1", "2", "3", "4", "5"),
                        List.of("6", "7", "8", "9", "10"),
                        List.of("11", "12", "13", "14", "15"),
                        List.of("16", "17", "18", "19", "20"),
                        List.of("21", "22", "23", "24", "25")
                )
        ));
    }

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        VectorJoiner<String> vectorJoiner = vector -> {
            if (vector.isEmpty()) {
                throw new IllegalArgumentException("Empty list");
            }

            StringBuilder sb = new StringBuilder();
            sb.append(vector.get(0));
            for (int i = 1; i < vector.size(); i++) {
                sb.append(", ");
                sb.append(vector.get(i));
            }
            return sb.toString();
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            if (matrix.isEmpty()) {
                throw new IllegalArgumentException("Empty matrix");
            }

            StringBuilder sb = new StringBuilder();
            for (List<String> strings : matrix) {
                sb.append(vectorJoiner.join(strings)).append("\n");
            }
            return sb.toString();
        };
        return matrixJoiner.join(table);
    }
}
