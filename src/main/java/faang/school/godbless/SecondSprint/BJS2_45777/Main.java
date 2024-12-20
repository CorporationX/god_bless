package faang.school.godbless.SecondSprint.BJS2_45777;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.deepToString(flipMatrix(matrix, FlipDirection.VERTICAL)));
        System.out.println(Arrays.deepToString(flipMatrix(matrix, FlipDirection.HORIZONTAL)));
    }

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] newMatrix = new int[rows][cols];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                Coordinate newCoordinates = transformer.transform(i, j);
                newMatrix[newCoordinates.getX()][newCoordinates.getY()] = matrix[i][j];
            }
        }

        return newMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix, (x, y) -> new Coordinate(x, matrix[0].length - 1 - y));
        } else if (flipDirection == FlipDirection.VERTICAL) {
            return transformMatrix(matrix, (x, y) -> new Coordinate(matrix.length - 1 - x, y));
        } else {
            throw new IllegalArgumentException("Invalid flip direction");
        }
    }
}
