package faang.school.godbless.lambda.task14csv;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(toCsv(
                List.of(
                        List.of("1", "2", "3", "4", "5"),
                        List.of("6", "7", "8", "9", "10"),
                        List.of("11", "12", "13", "14", "15"),
                        List.of("16", "17", "18", "19", "20"),
                        List.of("21", "22", "23", "24", "25")
                )
            )
        );
    }
    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        if (table.isEmpty()) {
            throw new IllegalArgumentException("Таблица пустая");
        }

        VectorJoiner<String> vj = list -> String.join(", ",list);

//        MatrixJoiner<String> matrixJoiner = matrix -> {
//            StringBuilder result = new StringBuilder();
//            for (List<String> row : matrix) {
//                result.append(vj.join(row)).append("\n");
//            }
//            return result.toString();
//        };

        MatrixJoiner<String> mj = matrix -> matrix.stream().
                map(vj::join).
                collect(Collectors.joining("\n"));

        return mj.join(table);
    }
}
