package faang.school.godbless.sprint_2.functional_interface.task_17_hogwarts.task_29_csv;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        String table = toCsv(
                List.of(
                        List.of("1", "2", "3", "4", "5"),
                        List.of("6", "7", "8", "9", "10"),
                        List.of("11", "12", "13", "14", "15"),
                        List.of("16", "17", "18", "19", "20"),
                        List.of("21", "22", "23", "24", "25")
                )
        );

        System.out.println(table);
    }

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        VectorJoiner<String> vectorJoiner = l -> String.join(", ", l.toArray(new String[0]));

        MatrixJoiner<String> matrixJoiner = m -> {
            List<String> tempList = new ArrayList<>();

            for (List<String> strings : m) {
                tempList.add(vectorJoiner.join(strings));
            }
            return String.join("\n", tempList);
        };

        return matrixJoiner.join(table);
    }
}
