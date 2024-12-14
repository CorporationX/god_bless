package school.faang.sprint_2.task_45660;

public class MatrixUtils {
    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transformedMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Coordinates coordinates = transformer.transform(i, j);
                transformedMatrix[coordinates.getX()][coordinates.getY()] = matrix[i][j];
            }
        }

        return transformedMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] flippedMatrix = new int[rows][cols];

        if (flipDirection == FlipDirection.HORIZONTAL) {

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    flippedMatrix[i][cols - j - 1] = matrix[i][j];
                }
            }
        } else if (flipDirection == FlipDirection.VERTICAL) {

            for (int i = 0; i < rows; i++) {
                System.arraycopy(matrix[i], 0, flippedMatrix[rows - i - 1], 0, cols);
            }
        }

        return flippedMatrix;
    }
}
