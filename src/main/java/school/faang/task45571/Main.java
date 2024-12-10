package school.faang.task45571;

import java.util.Arrays;

import static school.faang.task45571.FlipDirection.HORIZONTAL;
import static school.faang.task45571.FlipDirection.VERTICAL;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1, 0}, {2, 3}};

        System.out.println(Arrays.deepToString(flipMatrix(matrix, HORIZONTAL)));
    }

    private static void validateMatrix(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("matrix can`t be null");
        }
    }

    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer matrixTransformer) {
        validateMatrix(matrix);
        if (matrixTransformer == null) {
            throw new IllegalArgumentException("matrixTransformer can`t be null");
        }

        int[][] flippedMatrix = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                Coordinates coordinates = matrixTransformer.transform(i, j);
                flippedMatrix[coordinates.getFirstCoordinate()][coordinates.getSecondCoordinate()] = matrix[i][j];
            }
        }
        return flippedMatrix;
    }

    private static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        validateMatrix(matrix);
        if (flipDirection == null) {
            throw new IllegalArgumentException("flipDirection can`t be null");
        }

        int[][] resultMatrix;

        if (flipDirection == HORIZONTAL) {
            resultMatrix = transformMatrix(matrix, (i, j) -> new Coordinates(i, matrix.length - 1 - j));
        } else if (flipDirection == VERTICAL) {
            resultMatrix = transformMatrix(matrix, (i, j) -> new Coordinates(matrix.length - 1 - i, j));
        } else {
            throw new IllegalArgumentException("flipDirection is not selected");
        }

        return resultMatrix;
    }
}
