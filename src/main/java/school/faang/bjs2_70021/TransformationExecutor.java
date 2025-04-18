package school.faang.bjs2_70021;

public class TransformationExecutor {
    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (flipDirection == FlipDirection.HORIZONTAL) {
            return transformMatrix(matrix, (a, b) -> new Coordinates((a + 1) % matrix[0].length, b));
        } else {
            return transformMatrix(matrix, (a, b) -> new Coordinates(a, (b + 1) % matrix.length));
        }
    }

    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] newMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Coordinates coordinates = transformer.transform(i, j);
                newMatrix[coordinates.getCoordinateY()][coordinates.getCoordinateX()] = matrix[j][i];
            }
        }
        return newMatrix;
    }
}