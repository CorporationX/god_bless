package school.faang.bjs2_80201;

import java.util.Iterator;
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
        return MATRIX_JOINER.join(table);
    }

    private static final VectorJoiner<String> VECTOR_JOINER = (vector) -> {
        if (vector == null || vector.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = vector.iterator();
        sb.append(it.next());
        while (it.hasNext()) {
            sb.append(", ");
            sb.append(it.next());
        }
        return sb.toString();
    };
    private static final MatrixJoiner<String> MATRIX_JOINER = matrix -> {
        if (matrix.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        StringBuilder builder = new StringBuilder();
        matrix.forEach(vector -> {
            builder.append(VECTOR_JOINER.join(vector)).append("\n");
        });
        return builder.toString();
    };

}
