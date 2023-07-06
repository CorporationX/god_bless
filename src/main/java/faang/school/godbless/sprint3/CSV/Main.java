package faang.school.godbless.sprint3.CSV;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        toCsv(
                List.of(
                        List.of("1", "2", "3", "4", "5"),
                        List.of("6", "7", "8", "9", "10"),
                        List.of("11", "12", "13", "14", "15"),
                        List.of("16", "17", "18", "19", "20"),
                        List.of("21", "22", "23", "24", "25")
                )
        );
    }

    static VectorJoiner<String> vector = (list, str) -> {
        return list.stream()
                .collect(Collectors.joining(str)) + "\n";
    };


    static MatrixJoiner<String> matrix = (lists) -> {
        List<String> res = new ArrayList<>();
        for (List<String> l : lists) {
            res.add(vector.join(l, ", "));
        }
        return vector.join(res, "");
    };

    private static void toCsv(List<List<String>> lists) {
        System.out.println(matrix.join(lists));
    }
}
