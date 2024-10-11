package school.faang.rotate.the.matrix;

public class MatrixConverter {
    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        return switch (flipDirection) {
            case VERTICAL -> transformMatrix(matrix, (x, y) -> new Coordinates(matrix.length - 1 - x, y));
            case HORIZONTAL -> transformMatrix(matrix, (x, y) -> new Coordinates(x, matrix[0].length - 1 - y));
        };
    }

    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Coordinates transform = transformer.transform(i, j);
                result[i][j] = matrix[transform.getX()][transform.getY()];
            }
        }
        return result;
    }
}
