package faang.school.godbless.matrixRotate;

public class MatrixProcessor {
    public static int[][] flipMatrix(int[][] matrix, FlipDirection direction) {
        checkDirection(direction);
        MatrixTransformer horizontalTransform = (x, y) -> new Coordinates(x, matrix.length - y - 1);
        MatrixTransformer verticalTransform = (x, y) -> new Coordinates(matrix.length - x - 1, y);
        return direction.equals(FlipDirection.HORIZONTAL) ? transformMatrix(matrix, horizontalTransform) : transformMatrix(matrix, verticalTransform);
    }

    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }
        Coordinates result;
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                result = transformer.transform(i, j);
                newMatrix[result.getX()][result.getY()] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    private static void checkDirection(FlipDirection flipDirection) {
        if (!(flipDirection.equals(FlipDirection.VERTICAL) || flipDirection.equals(FlipDirection.HORIZONTAL))) {
            throw new IllegalArgumentException();
        }
    }
}
