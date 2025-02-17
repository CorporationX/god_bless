package school.faang.task_59726;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class MatrixProcess {
    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] newMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Coordinates newCoords = transformer.rotatedCoordinates(i, j);
                if (newCoords.getRow() < rows && newCoords.getColumn() < cols) {
                    newMatrix[newCoords.getRow()][newCoords.getColumn()] = matrix[i][j];
                }
            }
        }
        return newMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        try {
            if (flipDirection == FlipDirection.HORIZONTAL) {
                return transformMatrix(matrix, (y, x) -> new Coordinates(y, matrix[0].length - 1 - x));
            } else if (flipDirection == FlipDirection.VERTICAL) {
                return transformMatrix(matrix, (y, x) -> new Coordinates(matrix.length - 1 - y, x));
            } else {
                log.info("This type of flip has not yet been implemented.");
            }
        } catch (IllegalArgumentException e) {
            log.info("Error: {}", e.getMessage());
        }
        return matrix;
    }

    static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
