package faang.school.godbless.lambda_stream.transformation;

public class Transformation {

    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transformedMatrix = new int[rows][cols];
        Coordinates newCoordinates;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newCoordinates = transformer.transform(i, j);
                transformedMatrix[newCoordinates.getX()][newCoordinates.getY()] = matrix[i][j];
            }
        }
        return transformedMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix, (x, y) -> new Coordinates(x, cols - 1 - y));
        } else
            return transformMatrix(matrix, (x, y) -> new Coordinates(rows - 1 - x, y));
    }
}