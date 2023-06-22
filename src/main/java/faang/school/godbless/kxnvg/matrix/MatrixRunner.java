package faang.school.godbless.kxnvg.matrix;

public class MatrixRunner {

    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Coordinates coordinates = transformer.transform(i, j);
                newMatrix[coordinates.getX()][coordinates.getY()] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(x, matrix[x].length - y - 1));
        } else {
            return transformMatrix(matrix, ((x, y) -> new Coordinates(matrix.length - x - 1, y)));
        }
    }
}
