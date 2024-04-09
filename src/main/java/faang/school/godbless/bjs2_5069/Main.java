package faang.school.godbless.bjs2_5069;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String result = toCsv(List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25")
        ));
        System.out.println(result);
    }

    public static String toCsv(List<List<String>> table) {
        VectorJoiner<String> vectorJoinerString = vector -> String.join(", ", vector);

        MatrixJoiner<String> stringMatrixJoiner = matrix -> {
            StringBuilder sb = new StringBuilder();
            for (List<String> vector : matrix) {
                sb.append(vectorJoinerString.join(vector)).append("\n");
            }
            return sb.toString();
        };

        return stringMatrixJoiner.join(table);
    }
}
