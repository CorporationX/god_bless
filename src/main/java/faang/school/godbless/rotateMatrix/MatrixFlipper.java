package faang.school.godbless.rotateMatrix;

public class MatrixFlipper {
    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer matrixTransformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                var newCoordinates = matrixTransformer.transform(i, j);
                newMatrix[newCoordinates.getX()][newCoordinates.getY()] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (matrix.length == 0) {
            return new int[0][0];
        }
        MatrixTransformer matrixTransformer;
        if (flipDirection == FlipDirection.VERTICAL) {
            matrixTransformer = (x, y) -> new Coordinates(matrix[0].length - x - 1, y);
        } else if (flipDirection == FlipDirection.HORIZONTAL) {
            matrixTransformer = ((x, y) -> new Coordinates(x, matrix.length - y - 1));
        } else {
            throw new IllegalArgumentException(String.format("Flip direction %s is not implemented", flipDirection.name()));
        }
        return transformMatrix(matrix, matrixTransformer);
     }
}
