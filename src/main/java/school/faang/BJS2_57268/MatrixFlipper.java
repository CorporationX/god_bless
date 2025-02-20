package school.faang.BJS2_57268;

import lombok.NonNull;

public class MatrixFlipper {
    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int length = matrix.length;
        int width = matrix[0].length;
        int[][] newMatrix = new int[length][width];

        for (int row = 0; row < length; row++) {
            for (int col = 0; col < width; col++) {
                Coordinates coordinates = transformer.transform(row, col);
                newMatrix[row][col] = matrix[coordinates.getRow()][coordinates.getColumn()];
            }
        }
        return newMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix,
                                     @NonNull FlipDirection flipDirection) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Matrix is null or empty");
        }
        int length = matrix.length;
        int width = matrix[0].length;

        if (flipDirection == FlipDirection.HORIZONTAL) {
            MatrixTransformer horizontal = ((x, y) -> new Coordinates(x, (width - y - 1)));
            return transformMatrix(matrix, horizontal);
        } else if (flipDirection == FlipDirection.VERTICAL) {
            MatrixTransformer vertical = ((x, y) -> new Coordinates((length - x - 1), y));
            return transformMatrix(matrix, vertical);
        } else {
            throw new IllegalArgumentException("Unsupported flip direction");
        }
    }
}
