package faang.school.godbless.rotate.matrix;

public class Martix {
    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }
        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                var newCoordinates = transformer.transform(i, j);
                newMatrix[newCoordinates.getX()][newCoordinates.getY()] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (matrix.length == 0) {
            return new int[0][0];
        }
        return switch (flipDirection) {
            case VERTICAL -> transformMatrix(matrix, (x, y) ->
                    new Coordinates(matrix.length - x - 1, y)
            );
            case HORIZONTAL -> transformMatrix(matrix, (x, y) ->
                    new Coordinates(x, matrix[0].length - y - 1)
            );
        };
    }
}