package bjs2_57242;

public class MatrixUtils {
    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;
        int[][] result = new int[rowCount][columnCount];

        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                Coordinates newCoordinates = transformer.transform(row, column);
                result[newCoordinates.x()][newCoordinates.y()] = matrix[row][column];
            }
        }

        return result;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (matrix == null) {
            throw new IllegalArgumentException("Аргумент 'matrix' не может быть равен null");
        }

        int rowCount = matrix.length;
        int columnCount = matrix[0].length;

        MatrixTransformer transformer = switch (flipDirection) {
            case VERTICAL -> (x, y) -> new Coordinates(rowCount - 1 - x, y);
            case HORIZONTAL -> (x, y) -> new Coordinates(x, columnCount - 1 - y);
        };

        return transformMatrix(matrix, transformer);
    }
}
