package school.faang.bjs2_90600;

public class MatrixUtils {
    private static final MatrixTransformer HORIZONTAL_FLIP_TRANSFORMER =
            (x, y) -> new Coordinates(x, -1);

    private static final MatrixTransformer VERTICAL_FLIP_TRANSFORMER =
            (x, y) -> new Coordinates(-1, y);

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        final int matrixSize = matrix.length;
        int[][] result = new int[matrixSize][matrixSize];

        for (int x = 0; x < matrixSize; x++) {
            for (int y = 0; y < matrixSize; y++) {
                Coordinates newCoords = transformer.transform(x, y);
                int newX = newCoords.getX() == -1 ? matrixSize - 1 - x : newCoords.getX();
                int newY = newCoords.getY() == -1 ? matrixSize - 1 - y : newCoords.getY();
                result[newX][newY] = matrix[x][y];
            }
        }
        return result;
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix, HORIZONTAL_FLIP_TRANSFORMER);
        } else {
            return transformMatrix(matrix, VERTICAL_FLIP_TRANSFORMER);
        }
    }
}