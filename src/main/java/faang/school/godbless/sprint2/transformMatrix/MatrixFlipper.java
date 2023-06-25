package faang.school.godbless.sprint2.transformMatrix;

public class MatrixFlipper {

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                Coordinates newCoordinates = transformer.transform(i, j);
                newMatrix[newCoordinates.x()][newCoordinates.y()] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        MatrixTransformer matrixTransformer;
        if (flipDirection == FlipDirection.VERTICAL) {
            matrixTransformer = (x, y) -> new Coordinates(matrix[0].length - x - 1, y);
        } else if (flipDirection == FlipDirection.HORIZONTAL) {
            matrixTransformer = ((x, y) -> new Coordinates(x, matrix.length - y - 1));
        } else {
            throw new IllegalArgumentException("Flip direction %s is not implemented");
        }
        return transformMatrix(matrix, matrixTransformer);
    }
}
