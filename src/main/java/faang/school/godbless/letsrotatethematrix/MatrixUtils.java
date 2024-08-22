package faang.school.godbless.letsrotatethematrix;

public class MatrixUtils {
    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Coordinates newCoordinates = transformer.transform(i, j);
                newMatrix[newCoordinates.getX()][newCoordinates.getY()] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        int n = matrix.length;
        MatrixTransformer transformer;

        if (flipDirection == FlipDirection.HORIZONTAL) {
            transformer = (x, y) -> new Coordinates(x, n - 1 - y);
        } else {
            transformer = (x, y) -> new Coordinates(n - 1 - x, y);
        }
        return transformMatrix(matrix, transformer);
    }
}