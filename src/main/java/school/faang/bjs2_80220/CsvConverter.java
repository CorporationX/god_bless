package school.faang.bjs2_80220;

import java.util.List;

public class CsvConverter {

    public static String toCsv(List<List<String>> table) {
        VectorJoiner<String> vectorJoiner = row -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < row.size(); i++) {
                sb.append(row.get(i));
                if (i < row.size() - 1) {
                    sb.append(", ");
                }
            }
            return sb.toString();
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < matrix.size(); i++) {
                sb.append(vectorJoiner.join(matrix.get(i)));
                if (i < matrix.size() - 1) {
                    sb.append("\n");
                }
            }
            return sb.toString();
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

        System.out.println(toCsv(table));
    }
}
