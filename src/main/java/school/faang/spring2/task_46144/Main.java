package school.faang.spring2.task_46144;

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
        VectorJoiner<String> joiner = (list) -> {
            StringBuilder builder = new StringBuilder();
            for (String s : list) {
                builder.append(s).append(", ");
            }
            builder.setLength(builder.length() - 2);
            return builder.toString();
        };

        MatrixJoiner<String> csv = (matrix -> {
            StringBuilder builder = new StringBuilder();
            for (List<String> list : matrix) {
                builder.append(joiner.join(list));
                builder.append("\n");
            }
            return builder.toString();
        });
        return csv.join(table);
    }
}
