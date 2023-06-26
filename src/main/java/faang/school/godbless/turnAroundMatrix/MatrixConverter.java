package faang.school.godbless.turnAroundMatrix;

public class MatrixConverter {
    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        int[][] flipMatrix = new int[][]{};
        MatrixTransformer horizontalTransform = (x, y) -> new Coordinates(x, matrix[0].length - 1 - y);
        MatrixTransformer verticalTransform = (x, y) -> new Coordinates(matrix.length - 1 - x, y);

        if (flipDirection.equals(FlipDirection.HORIZONTAL)) {
            flipMatrix = transformMatrix(matrix, horizontalTransform);
        } else {
            flipMatrix = transformMatrix(matrix, verticalTransform);
        }
        return flipMatrix;
    }

    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[][]{};
        }

        int[][] transformMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                Coordinates changedCoordinates = transformer.turnAround(i, j);
                transformMatrix[changedCoordinates.getX()][changedCoordinates.getY()] = matrix[i][j];
            }
        }
        return transformMatrix;
    }
}