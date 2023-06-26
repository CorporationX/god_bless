package faang.school.godbless.Sprint_3.CSV;

import java.util.List;

public class Application {
    public static String toCSV(List<List<String>> table) throws IllegalArgumentException {
        if(table == null) throw new IllegalArgumentException("table is null");

        VectorJoiner<String> vectorJoiner = list -> String.join(", ", list);

        MatrixJoiner<String> matrixJoiner = lists -> {
            if(lists == null || lists.isEmpty()) throw new IllegalArgumentException("table is empty");
            StringBuilder matrix = new StringBuilder();
            matrix.append(vectorJoiner.join(lists.get(0)));
            for(int i = 1; i < lists.size(); i++) {
                matrix.append("\n").append(vectorJoiner.join(lists.get(i)));
            }
            return String.valueOf(matrix);
        };

        return matrixJoiner.join(table);
    }

}
