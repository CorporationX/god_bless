package school.faang.task_46147;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String csv = toCsv(
                List.of(
                        List.of("1", "2", "3", "4", "5"),
                        List.of("6", "7", "8", "9", "10"),
                        List.of("11", "12", "13", "14", "15"),
                        List.of("16", "17", "18", "19", "20"),
                        List.of("21", "22", "23", "24", "25")
                )
        );
        System.out.println(csv);
    }

    public static String toCsv(List<List<String>> table) {
        VectorJoiner<String> vectorJoiner = vector -> String.join(", ", vector);

        MatrixJoiner<String> matrixJoiner = matrix -> {
            List<String> joinedVector =  matrix.stream()
                    .map(vectorJoiner::join)
                    .toList();

            return String.join("\n", joinedVector);
        };

        return matrixJoiner.join(table);
    }

}
