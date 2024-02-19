package faang.school.godbless.buildcsv;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String res = toCsv(
                List.of(
                        List.of("1", "2", "3", "4", "5"),
                        List.of("6", "7", "8", "9", "10"),
                        List.of("11", "12", "13", "14", "15"),
                        List.of("16", "17", "18", "19", "20"),
                        List.of("21", "22", "23", "24", "25")
                )
        );
        System.out.println(res);
    }

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        VectorJoiner<String> vectorJoiner = vector -> {
            validateList(vector);
            StringBuilder builder = new StringBuilder();
            builder.append(vector.get(0));
            for (int i = 1; i < vector.size(); i++) {
                builder.append(", ");
                builder.append(vector.get(i));
            }
            return builder.toString();
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            validateList(matrix);
            StringBuilder builder = new StringBuilder();
            builder.append(vectorJoiner.join(matrix.get(0)));
            for (int i = 1; i < matrix.size(); i++) {
                builder.append("\n");
                builder.append(vectorJoiner.join(matrix.get(i)));
            }
            return builder.toString();
        };

        return matrixJoiner.join(table);
    }

    public static void validateList(List<?> list) {
        if (list == null) {
            throw new IllegalArgumentException("List can't be null");
        }
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List can't be empty");
        }
    }
}
