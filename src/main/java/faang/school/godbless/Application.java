package faang.school.godbless;

import java.util.Arrays;

public class Application {
    public static void main(String... args) {
        System.out.println(Arrays.deepToString(flipMatrix(new int[][]{{5, 7, 3}, {7, 0, 1}, {8, 1, 2}}, FlipDirection.VERTICAL)));
    }

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int[][] transformedMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Coordinates coordinates = transformer.transform(i, j);
                transformedMatrix[coordinates.getI()][coordinates.getJ()] = matrix[i][j];
            }
        }
        return transformedMatrix;
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix, (i, j) -> {
                j = matrix[0].length - 1 - j;
                return new Coordinates(i, j);
            });
        } else {
            return transformMatrix(matrix, (i, j) -> {
                i = matrix.length - 1 - i;
                return new Coordinates(i, j);
            });
        }
    }
}
