package school.faang.turnmatrix;

public class Coordinates {
    private final int x;
    private final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transformedMatrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Coordinates newCoords = transformer.transform(row, col);
                transformedMatrix[newCoords.getX()][newCoords.getY()] = matrix[row][col];
            }
        }

        return transformedMatrix;
    }

    public enum FlipDirection {
        HORIZONTAL, VERTICAL
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix, (row, col) -> new Coordinates(row, matrix[0].length - 1 - col));
        } else if (flipDirection == FlipDirection.VERTICAL) {
            return transformMatrix(matrix, (row, col) -> new Coordinates(matrix.length - 1 - row, col));
        }
        throw new IllegalArgumentException("Unknown FlipDirection: " + flipDirection);
    }


}
