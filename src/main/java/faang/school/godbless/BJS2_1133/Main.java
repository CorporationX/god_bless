package faang.school.godbless.BJS2_1133;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        VectorJoiner<String> vectorJoiner = list -> String.join(", ", list);
        MatrixJoiner<String> matrixJoiner = listOfLists -> String.join("\n",
                listOfLists.stream().map(vectorJoiner::join).toList()
        );
        return matrixJoiner.join(table);
    }
}
