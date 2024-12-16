package school.faang.task_46152;

import java.util.List;

public class Main {

    public static String toCsv(List<List<String>> table) {
        VectorJoiner<String> vectorJoiner = vector -> {
            if (vector == null || vector.isEmpty()) {
                throw new IllegalArgumentException("\nОшибка: Пустой список вектора (строки таблицы)");
            }
            StringBuilder builder = new StringBuilder();
            builder.append(vector.get(0));
            for (int i = 1; i < vector.size(); i++) {
                builder.append(", ").append(vector.get(i));
            }
            return builder.toString();
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            if (matrix == null || matrix.isEmpty()) {
                throw new IllegalArgumentException("\nОшибка: Пустой список матрицы (таблицы)");
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < matrix.size(); i++) {
                if (i > 0) {
                    builder.append("\n");
                }
                builder.append(vectorJoiner.join(matrix.get(i)));
            }
            return builder.toString();
        };

        return matrixJoiner.join(table);
    }


    public static void main(String[] args) {

        List<List<String>> table = List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25")
        );

        String csv = toCsv(table);

        System.out.println(csv);
    }
}
