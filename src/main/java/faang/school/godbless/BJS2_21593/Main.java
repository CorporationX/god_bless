package faang.school.godbless.BJS2_21593;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> listToCsv = List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25")
        );
        System.out.println(toCsv(listToCsv));
    }

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        if (table.isEmpty()) {
            throw new IllegalArgumentException("table is empty");
        }

        VectorJoiner<String> vectorJoiner = vector -> {
            if (vector.isEmpty()) {
                throw new IllegalArgumentException("vector is empty");
            }
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < vector.size(); i++) {
                line.append(vector.get(i));
                if (i < vector.size() - 1) {
                    line.append(",");
                }
            }
            return line.toString();
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            StringBuilder row = new StringBuilder();
            matrix.forEach(list -> row.append(vectorJoiner.join(list)).append("\n"));
            return row.toString();
        };

        return matrixJoiner.join(table);
    }
}
