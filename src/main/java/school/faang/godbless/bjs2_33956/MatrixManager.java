package school.faang.godbless.bjs2_33956;

public class MatrixManager {
    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int[][] transformedMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                Coordinates coordinates = transformer.transfrom(i, j);
                transformedMatrix[coordinates.getX()][coordinates.getY()] = matrix[i][j];
            }
        }
        return transformedMatrix;
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        MatrixTransformer horizontalTransformer = (x, y) -> {
            if (y < matrix[x].length / 2) {
                y = matrix[x].length - 1 - y;
            } else {
                y = matrix[x].length - 1 - y;
            }
            return new Coordinates(x, y);
        };

        MatrixTransformer verticalTransformer = (x, y) -> {
            if (x < matrix.length / 2) {
                x = matrix.length - 1 - x;
            } else {
                x = matrix.length - 1 - x;
            }
            return new Coordinates(x, y);
        };

        if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix, horizontalTransformer);
        } else {
            return transformMatrix(matrix, verticalTransformer);
        }
    }

    public static enum FlipDirection {
        HORIZONTAL, VERTICAL
    }
}
