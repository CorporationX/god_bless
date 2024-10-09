package school.faang.matrix;

import java.util.Arrays;
import java.util.Optional;

public class TestClass {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}};

        printMatrix(matrix, "Source array:");

        FlipDirection.getDirections().forEach(dir -> {
            flipMatrix(matrix, dir).ifPresent(result ->
                    printMatrix(result, dir.toString() + " transformation:"));
        });
    }

    private static Optional<int[][]> flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(x, matrix[0].length - 1 - y));
        } else if (flipDirection == FlipDirection.VERTICAL) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(matrix.length - 1 - x, y));
        }
        return Optional.empty();
    }

    private static Optional<int[][]> transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (isNotValid(matrix)) {
            return Optional.empty();
        }

        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Coordinates coord = transformer.transform(i, j);
                result[i][j] = matrix[coord.getX()][coord.getY()];
            }
        }
        return Optional.of(result);
    }

    private static boolean isNotValid(int[][] matrix) {
        return matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0 || matrix.length != matrix[0].length;
    }

    private static void printMatrix(int[][] matrix, String message) {
        System.out.println(message);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
