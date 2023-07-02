package faang.school.godbless.flip_matrix;

public class MatrixTransformProcessor {
    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int[][] transformMatrix = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Coordinates coordinates = new Coordinates(i, j);
                Coordinates transformCoordinates = transformer.run(coordinates);
                transformMatrix[transformCoordinates.getX()][transformCoordinates.getY()] = matrix[i][j];
            }
        }
        return transformMatrix;
    }
}
