package school.faang.bjs2_80301;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class MatrixOperations {

    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] newMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Coordinates coords = transformer.transform(i, j);
                newMatrix[coords.coordinateX()][coords.coordinateY()] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection direction) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        return switch (direction) {
            case HORIZONTAL -> transformMatrix(matrix,
                    (i, j) -> new Coordinates(i, cols - 1 - j));

            case VERTICAL -> transformMatrix(matrix,
                    (i, j) -> new Coordinates(rows - 1 - i, j));
        };
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            log.info(Arrays.toString(row));
        }
    }
}
