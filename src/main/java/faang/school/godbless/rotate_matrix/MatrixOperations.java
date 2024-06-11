package faang.school.godbless.rotate_matrix;

public class MatrixOperations {
    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix == null || transformer == null) {
            throw new IllegalArgumentException("Matrix and transformer cannot be null values");
        }
        int matrixSize = matrix.length;
        int[][] resultMatrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                Coordinates newCoordinates = transformer.transform(matrixSize, i, j);
                resultMatrix[i][j] = matrix[newCoordinates.getX()][newCoordinates.getY()];
            }
        }
        return resultMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        return transformMatrix(matrix, flipDirection.getMatrixTransformer());
    }

    public static void showMatrix(int[][] matrix){
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
