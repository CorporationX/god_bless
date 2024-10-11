package school.faang.task2115.matrix;

import school.faang.task2115.FlipDirection;
import school.faang.task2115.coordinate.Coordinates;

public class Matrix {
    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            throw new IllegalArgumentException();
        }
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Coordinates coord = transformer.flip(i, j);
                result[coord.getX()][coord.getY()] = matrix[i][j];
            }
        }
        return result;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(x, matrix[x].length - 1 - y));
        } else if (flipDirection == FlipDirection.VERTICAL) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(matrix.length - 1 - x, y));
        } else throw new IllegalArgumentException();
    }
}
