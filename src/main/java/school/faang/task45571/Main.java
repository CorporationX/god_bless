package school.faang.task45571;

import java.util.Arrays;

import static school.faang.task45571.FlipDirection.HORIZONTAL;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1, 0}, {2, 3}};

        System.out.println(Arrays.deepToString(flipMatrix(matrix, HORIZONTAL)));
    }

    private static void validateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("matrix can`t be null or empty");
        }

        int rowLength = matrix[0].length;

        Arrays.stream(matrix).forEach(array -> {
            if (array.length != rowLength) {
                throw new IllegalArgumentException("the strings must be of the same length");
            }
        });
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
                flippedMatrix[coordinates.row()][coordinates.column()] = matrix[i][j];
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
        } else {
            resultMatrix = transformMatrix(matrix, (i, j) -> new Coordinates(matrix.length - 1 - i, j));
        }

        return resultMatrix;
    }
}
