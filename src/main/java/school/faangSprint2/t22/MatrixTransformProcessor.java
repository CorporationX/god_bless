package school.faangSprint2.t22;

public class MatrixTransformProcessor {
    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                Coordinates newCoordinates = transformer.transform(i, j);
                newMatrix[newCoordinates.getX()][newCoordinates.getY()] = matrix[i][j];
            }
        }

        return newMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        return switch (flipDirection) {
            case HORIZONTAL -> transformMatrix(matrix, (x, y) -> new Coordinates(x, matrix[0].length - 1 - y));
            case VERTICAL -> transformMatrix(matrix, (x, y) -> new Coordinates(matrix.length - 1 - x, y));
            default -> throw new IllegalArgumentException("Invalid flip direction");
        };
    }
}