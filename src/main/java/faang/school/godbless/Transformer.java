package faang.school.godbless;

public class Transformer {
    private int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }
        int[][] temp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Coordinates positions = transformer.transform(i, j);
                temp[positions.getX()][positions.getY()] = matrix[i][j];
            }
        }
        return temp;
    }

    public int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Empty matrix");
        }
        if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix, (row, col) -> new Coordinates(row, matrix[0].length - col - 1));
        } else {
            return transformMatrix(matrix, (row, col) -> new Coordinates(matrix.length - row - 1, col));
        }
    }
}
