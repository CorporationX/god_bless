package sprint3.matrix;

@FunctionalInterface
public interface MatrixTransformer {
    Coordinates transform(Integer x, Integer y);

    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                Coordinates coordinates = transformer.transform(i, j);
                newMatrix[coordinates.getX()][coordinates.getY()] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix, (x, y) -> Coordinates.of(x, matrix[0].length - 1 - y));
        } else {
            return transformMatrix(matrix, (x, y) -> Coordinates.of(matrix.length - 1 - x, y));
        }
    }

    enum FlipDirection {
        HORIZONTAL,
        VERTICAL,
    }
}
