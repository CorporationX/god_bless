package school.faang.task_45562;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(Arrays.deepToString(flipMatrix(matrix, FlipDirection.HORIZONTAL)));
        System.out.println(Arrays.deepToString(flipMatrix(matrix, FlipDirection.VERTICAL)));
    }

    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer matrixTransformer) {
        int[][] result = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                Coordinates coordinates = matrixTransformer.changeIndexes(i, j);
                result[coordinates.getX()][coordinates.getY()] = matrix[i][j];
            }
        }

        return result;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        MatrixTransformer matrixTransformer;

        switch (flipDirection) {
            case VERTICAL -> matrixTransformer =
                    (i, j) -> new Coordinates(i, matrix.length - j - 1);
            case HORIZONTAL -> matrixTransformer =
                    (i, j) -> new Coordinates(matrix.length - i - 1, j);
            default -> throw new IllegalArgumentException("There is no side!");
        }

        return transformMatrix(matrix, matrixTransformer);
    }

    public static void printMatrix(int[][] matrix) {

    }
}
