package faang.school.godbless.flip_a_matrix;

import static faang.school.godbless.flip_a_matrix.FlipDirection.HORIZONTAL;
import static faang.school.godbless.flip_a_matrix.FlipDirection.VERTICAL;

public class Matrix {

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        Coordinates coordinates;
        int x;
        int y;

        int matrixLen = matrix.length;
        int vectorLen = matrix[0].length;
        int[][] transformedMatrix = new int[matrixLen][vectorLen];

        for (int i = 0; i < matrixLen; i++) {
            for (int j = 0; j < vectorLen; j++) {
                coordinates = transformer.transformMatrix(i, j);
                x = coordinates.getX();
                y = coordinates.getY();

                transformedMatrix[x][y] = matrix[i][j];
            }
        }

        return transformedMatrix;
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        validateDirection(flipDirection);

        if (flipDirection.equals(HORIZONTAL)) {
            return flipHorizontally(matrix);
        } else {
            return flipVertically(matrix);
        }
    }

    static int[][] flipHorizontally(int[][] matrix) {
        return transformMatrix(matrix, (x, y) -> new Coordinates(x, matrix[0].length - 1 - y));
    }

    static int[][] flipVertically(int[][] matrix) {
        return transformMatrix(matrix, (x, y) -> new Coordinates(matrix.length - x - 1, y));
    }

    static void validateDirection(FlipDirection flipDirection) {
        if (!flipDirection.equals(HORIZONTAL) && !flipDirection.equals(VERTICAL)) {
            throw new IllegalArgumentException("Invalid direction");
        }
    }
}

