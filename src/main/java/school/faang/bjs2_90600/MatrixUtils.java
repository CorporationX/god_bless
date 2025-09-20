package school.faang.bjs2_90600;

public class MatrixUtils {

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        final int matrixSize = matrix.length;
        int[][] result = new int[matrixSize][matrixSize];

        for (int x = 0; x < matrixSize; x++) {
            for (int y = 0; y < matrixSize; y++) {
                Coordinates newCoords = transformer.transform(x, y);
                result[newCoords.getCoordinateX()][newCoords.getCoordinateY()] = matrix[x][y];
            }
        }
        return result;
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(x, matrix.length - 1 - y));
        } else {
            return transformMatrix(matrix, (x, y) -> new Coordinates(matrix.length - 1 - x, y));
        }
    }
}
