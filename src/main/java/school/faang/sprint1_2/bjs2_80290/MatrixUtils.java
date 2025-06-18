package school.faang.sprint1_2.bjs2_80290;

public class MatrixUtils {
    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Coordinates coordinates = transformer.transform(i, j);
                result[coordinates.getCoordinateX()][coordinates.getCoordinateY()] = matrix[i][j];
            }
        }

        return result;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix, (i, j) -> new Coordinates(i, cols - 1 - j));
        } else if (flipDirection == FlipDirection.VERTICAL) {
            return transformMatrix(matrix, (i, j) -> new Coordinates(rows - 1 - i, j));
        }
        throw new IllegalArgumentException("Направление переворота матрицы не определено");
    }

    public static void print(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
