package flip_matrix;

public class MatrixFlipper {
    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        MatrixTransformer transformer;
        if (flipDirection == FlipDirection.HORIZONTAL) {
            transformer = (x, y) -> new Coordinates(x, matrix[0].length - y - 1);
        } else {
            transformer = (x, y) -> new Coordinates(matrix.length - x - 1, y);
        }
        return transformMatrix(matrix, transformer);
    }

    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                Coordinates newCoordinates = transformer.transform(i, j);
                newMatrix[newCoordinates.x()][newCoordinates.y()] = matrix[i][j];
            }
        }
        return newMatrix;
    }
}
