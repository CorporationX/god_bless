package faang.school.godbless.MatrixMath;

public class MatrixMath {
    public enum FlipDirection {
        HORIZONTAL,
        VERTICAL,
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        MatrixTransformer transformer = switch (flipDirection) {
            case HORIZONTAL -> (x, y) -> new Coordinates(x, cols - y - 1);
            case VERTICAL -> (x, y) -> new Coordinates(rows - x - 1, y);
        };

        return transformMatrix(matrix, transformer);
    }

    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] newMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Coordinates newCoords = transformer.transform(i, j);
                newMatrix[newCoords.getX()][newCoords.getY()] = matrix[i][j];
            }
        }

        return newMatrix;
    }
}
