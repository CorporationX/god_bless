package faang.school.godbless.Sprint_3.Lambda.RotateMatrix;

public class Application {
    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) return new int[0][];
        int[][] resMatrix = new int[matrix.length][matrix[0].length];
        Coordinates coordinates;
        int x, y;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                coordinates = transformer.transform(i, j);
                x = coordinates.getX();
                y = coordinates.getY();
                resMatrix[x][y] = matrix[i][j];
            }
        }
        return resMatrix;
    }

    public enum FlipDirection {
        HORIZONTAL,
        VERTICAL,
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix, (i, j) -> new Coordinates(i, matrix[i].length - j - 1));
        }
        return transformMatrix(matrix, (i, j) -> new Coordinates(matrix.length - i - 1, j));
    }
}
