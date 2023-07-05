package faang.school.godbless;

import java.util.List;

public class Transform {
    public static void main(String[] args) {
        System.out.println(toCsv(List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25"))));
    }

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {

        VectorJoiner<String> vectorJoiner = vector -> {
            if (vector.isEmpty()) {
                throw new IllegalArgumentException("Empty List !");
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(vector.get(0));
            for (int i = 1; i < vector.size(); i++) {
                stringBuilder.append(", ").append(vector.get(i));
            }
            return stringBuilder.toString();
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            if (matrix.isEmpty()) {
                throw new IllegalArgumentException("Empty list !");
            }
            StringBuilder builder = new StringBuilder();
            builder.append(vectorJoiner.join(matrix.get(0)));
            for (List<String> strings : matrix) {
                String line = vectorJoiner.join(strings);
                builder.append("\n").append(line);
            }
            return builder.toString();
        };
        return matrixJoiner.join(table);
    }
}
