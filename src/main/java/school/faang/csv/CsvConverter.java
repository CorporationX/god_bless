package school.faang.csv;

import java.util.List;

public class CsvConverter {

    public static void main(String[] args) {
        System.out.println(toCsv(
                List.of(
                        List.of("1", "2", "3", "4", "5"),
                        List.of("6", "7", "8", "9", "10"),
                        List.of("11", "12", "13", "14", "15"),
                        List.of("16", "17", "18", "19", "20"),
                        List.of("21", "22", "23", "24", "25")
                )
        ));
    }

    public static String toCsv(List<List<String>> table) {
        VectorJoiner<String> vectorJoiner = (vector) -> joinVector(vector);
        MatrixJoiner<String> matrixJoiner = (matrix) -> {
            if (matrix == null) {
                throw new IllegalArgumentException("matrix не может быть null");
            }
            if (matrix.isEmpty()) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (List<String> row : matrix) {
                sb.append(vectorJoiner.join(row));
                sb.append("\n");
            }
            return sb.toString();
        };
        return matrixJoiner.join(table);
    }

    private static String joinVector(List<String> vector) {
        if (vector == null) {
            throw new IllegalArgumentException("list не может быть null");
        }
        if (vector.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(vector.get(0));
        for (int i = 0; i < vector.size(); i++) {
            sb.append(vector.get(i));
            sb.append(",");
        }
        return sb.toString();
    }
}
