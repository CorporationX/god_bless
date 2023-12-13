package faang.school.godbless.lambda.task15rotate_matrix;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {6, 4, 5, 3, 2},
                {9, 4, 5, 3, 2},
                {8, 3, 5, 1, 2},
                {6, 1, 4, 3, 2},
                {0, 4, 4, 3, 2}
        };

        Arrays.stream(flipMatrix(matrix,FlipDirection.HORIZONTAL))
                .map(row -> Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(", ")))
                .forEach(System.out::println);

        System.out.println();

        Arrays.stream(flipMatrix(matrix,FlipDirection.VERTICAL))
                .map(row -> Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(", ")))
                .forEach(System.out::println);
    }

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int[][] trMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Coordinates coordinates = transformer.transform(i, j);
                int x = coordinates.getX();
                int y = coordinates.getY();
                trMatrix[x][y] = matrix[i][j];
            }
        }
        return trMatrix;
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (flipDirection.equals(FlipDirection.VERTICAL)) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(matrix.length - x - 1, y));
        } else {
            return transformMatrix(matrix, (x, y) -> new Coordinates(x, matrix.length - y - 1));
        }
    }
}
