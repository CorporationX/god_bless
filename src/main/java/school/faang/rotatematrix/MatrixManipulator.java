package school.faang.rotatematrix;

public class MatrixManipulator {
    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] newMatrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Coordinates newCoords = transformer.transform(row, col);
                newMatrix[newCoords.getX()][newCoords.getY()] = matrix[row][col];
            }
        }

        return newMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        MatrixTransformer transformer;

        if (flipDirection == FlipDirection.HORIZONTAL) {
            // Define transformer for horizontal flip
            transformer = (row, col) -> new Coordinates(row, cols - col - 1);
        } else {
            // Define transformer for vertical flip
            transformer = (row, col) -> new Coordinates(rows - row - 1, col);
        }

        return transformMatrix(matrix, transformer);
    }
}
