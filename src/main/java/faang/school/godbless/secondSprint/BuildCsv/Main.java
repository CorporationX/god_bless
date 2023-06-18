package faang.school.godbless.secondSprint.BuildCsv;

import java.util.List;

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

        VectorJoiner<String> vectorJoiner = vector -> {
            if (vector.isEmpty()) {
                throw new IllegalArgumentException("Empty list");
            }
            StringBuilder stringBuilder = new StringBuilder();
            vector.forEach(e -> stringBuilder.append(e).append(", "));
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length() - 1);
            return stringBuilder.toString();
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            StringBuilder stringBuilder = new StringBuilder();
            matrix.forEach(e -> stringBuilder.append(vectorJoiner.join(e)).append("\n"));
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return stringBuilder.toString();
        };

        return matrixJoiner.join(table);
    }

    @FunctionalInterface
    public interface VectorJoiner<T> {
        T join(List<T> vector);
    }

    @FunctionalInterface
    public interface MatrixJoiner<T> {
        T join(List<List<T>> matrix);
    }
}
