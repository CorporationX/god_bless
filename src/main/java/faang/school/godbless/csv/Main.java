package faang.school.godbless.csv;

import java.util.*;
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
    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        Refactor refactor = new Refactor();
        StringBuilder result = new StringBuilder();

        VectorJoiner<String> vector = words -> words.stream().reduce((w1, w2) -> w1 + ",\t" + w2).orElseThrow();
        MatrixJoiner<String> matrix = words -> words.stream().map(line -> refactor.listToString(line, vector))
                .reduce((line1, line2) -> line1 + "\n" + line2).orElseThrow();
        return refactor.tableToString(table, matrix);
    }
}
