package school.faang.BJS2_33968_RotateMatrix;

public class MatrixOperations {
    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int[][] transformedMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++) {
                Coordinates newCoordinates = transformer.transformCoordinates(i, j);
                int newX = newCoordinates.getX();
                int newY = newCoordinates.getY();
                transformedMatrix[newX][newY] = matrix[i][j];
            }
        return transformedMatrix;
    }
}
