package faang.school.godbless.build_scv;

import java.util.ArrayList;
import java.util.List;

public class ScvBuilder {

    public static String toCsv(List<List<String>> table) {
        if (table.isEmpty()){
            throw new IllegalArgumentException("Table can't be empty");
        }

        LineJoiner<String> lineJoiner = line -> {
            return String.join(", ", line);
        };

        MatrixJoiner<String> matrixJoiner =
                matrix -> String.join("\n", matrix.stream()
                        .map(lineJoiner::join).toList());
        return matrixJoiner.join(table);
    }

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>(List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25"))
        );

        System.out.println(toCsv(list));
    }
}
