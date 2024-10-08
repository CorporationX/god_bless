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
        VectorJoiner<String> vectorJoiner = (list) -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size() - 1; i++) {
                sb.append(list.get(i));
                sb.append(",");
            }
            sb.append(list.get(list.size() - 1));
            return sb.toString();
        };
        MatrixJoiner<String> matrixJoiner = (matrix) -> {
            StringBuilder sb = new StringBuilder();
            for (List<String> row : matrix) {
                sb.append(vectorJoiner.join(row));
                sb.append("\n");
            }
            return sb.toString();
        };
        return matrixJoiner.join(table);
    }
}
