package school.faang.task_46137;

import school.faang.task_46137.joiners.MatrixJoiner;
import school.faang.task_46137.joiners.VectorJoiner;

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
        ));
    }

    public static String toCsv(List<List<String>> table) {
        VectorJoiner<String> vectorJoiner = v -> String.join(", ", v);

        MatrixJoiner<String> matrixJoiner = matrix -> matrix.stream()
                .map(vectorJoiner::join)
                .collect(Collectors.joining("\n"));

        return matrixJoiner.join(table);
    }
}
