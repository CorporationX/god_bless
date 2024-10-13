package ru.kraiush.BJS2_34266;

import java.util.List;

public class Main {

    public static String toCsv(List<List<String>> table) {
        VectorJoiner<String> vectorJoiner = vector -> {
            if (vector.isEmpty()) {
                throw new IllegalArgumentException("The vector is empty");
            }
            StringBuilder joinedVector = new StringBuilder();
            joinedVector.append(vector.get(0));
            for (int i = 1; i < vector.size(); i++) {
                joinedVector
                        .append(", ")
                        .append(vector.get(i));
            }

            return joinedVector.toString();
        };
        MatrixJoiner<String> matrixJoiner = matrix -> {
            if (matrix.isEmpty()) {
                throw new IllegalArgumentException("The table is empty");
            }
            StringBuilder joinedMatrix = new StringBuilder();
            for (List<String> vector : matrix) {
                joinedMatrix
                        .append(vectorJoiner.join(vector))
                        .append("\n");
            }
            return joinedMatrix.toString();
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
