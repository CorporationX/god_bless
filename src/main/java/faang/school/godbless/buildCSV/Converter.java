package faang.school.godbless.buildCSV;

import java.util.List;

public class Converter {
    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        if (table == null || table.isEmpty()) {
            throw new IllegalArgumentException("Таблица равна null или пуста!");
        }

        VectorJoiner<String> vectorJoiner = (list) -> {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("Список равен null или пуст!");
            }
            StringBuilder stb = new StringBuilder();
            stb.append(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                stb.append(", ");
                stb.append(list.get(i));
            }
            return stb.toString();
        };

        MatrixJoiner<String> matrixJoiner = (matrix) -> {
            if (matrix == null || matrix.isEmpty()) {
                throw new IllegalArgumentException("Список равен null или пуст!");
            }
            StringBuilder stb = new StringBuilder();
            for (List<String> strings : matrix) {
                stb.append(vectorJoiner.join(strings));
                stb.append("\n");
            }
            return stb.toString();
        };

        return matrixJoiner.join(table);
    }

    public static void main(String[] args) {
        String str = toCsv(
                List.of(
                        List.of("1", "2", "3", "4", "5"),
                        List.of("6", "7", "8", "9", "10"),
                        List.of("11", "12", "13", "14", "15"),
                        List.of("16", "17", "18", "19", "20"),
                        List.of("21", "22", "23", "24", "25")
                )
        );

        System.out.println(str);
    }
}
