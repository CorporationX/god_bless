package faang.school.godbless.Matrix;

public class Application {
    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix == null) {
            throw new IllegalArgumentException("Empty matrix");
        }
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                Coordinates coordinates = transformer.transform(row, column);
                result[coordinates.getRow()][coordinates.getColumn()] = matrix[row][column];
            }
        }
        return result;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (matrix.length == 0) {
            throw new IllegalArgumentException("Empty matrix");
        }
        if (flipDirection.equals(FlipDirection.HORIZONTAL)) {
            return transformMatrix(matrix, ((row, column) -> new Coordinates(row, matrix[row].length - column - 1)));
        } else {
            return transformMatrix(matrix, ((row, column) -> new Coordinates(matrix.length - row - 1, column)));
        }
    }
}
