package school.faang.transformation.matrix;

public class MatrixService {
    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int[][] result = new int[rowCount][colCount];
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                Coordinates coordinates = transformer.transform(row, col);
                result[row][col] = matrix[coordinates.getX()][coordinates.getY()];
            }
        }
        return result;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        MatrixTransformer vertical = (row, col) -> new Coordinates(matrix.length - 1 - row, col);
        MatrixTransformer horizontal = (row, col) -> new Coordinates(row, matrix[0].length - 1 - col);

        if (flipDirection == FlipDirection.VERTICAL) {
            return transformMatrix(matrix, vertical);
        } else {
            return transformMatrix(matrix, horizontal);
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.print(matrix[row][0]);
            for (int col = 1; col < matrix[row].length; col++) {
                System.out.print(" " + matrix[row][col]);
            }
            System.out.println();
        }
    }
}
