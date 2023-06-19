package csv;

import java.util.List;

public class Main {
    static VectorJoiner<String> vectorJoiner = vector -> {
        if (vector.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }

        StringBuilder builder = new StringBuilder();
        builder.append(vector.get(0));
        for (int i = 1; i < vector.size(); i++) {
            builder.append(", ");
            builder.append(vector.get(i));
        }
        return builder.toString();
    };

    static MatrixJoiner<String> matrixJoiner = matrix -> {
        if (matrix.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }
        
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < matrix.size(); i++) {
            builder.append(vectorJoiner.join(matrix.get(i))+ "\n");
        }
        return builder.toString();
    };
    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        return matrixJoiner.join(table);
    }

    public static void main(String[] args) {
        List<List<String>> lists = List.of(List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25"));
        System.out.println(toCsv(lists));
    }
}
