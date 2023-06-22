package faang.school.godbless.lets_bild_csv;

import java.util.List;

public class ToCsvConverter {
    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        VectorJoiner<String> vectorJoiner = vector -> {
            if (vector.isEmpty()) {
                throw new IllegalArgumentException("Empty list");
            }

            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < vector.size();  i++){
                builder.append(vector.get(i));
                builder.append(", ");
            }
            builder.delete(builder.length()-2, builder.length());
            return builder.toString();
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            if (matrix.isEmpty()) {
                throw new IllegalArgumentException("Empty list");
            }

            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < matrix.size(); i++) {
                builder.append(vectorJoiner.join(table.get(i)));
                builder.append("\n");
            }
            return builder.toString();
        };
        return matrixJoiner.join(table);
    }

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
}
