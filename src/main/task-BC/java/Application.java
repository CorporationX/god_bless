import java.util.Arrays;

public class Application {

    static MatrixTransformer matrixTransformer = (x, y) -> new Coordinates(y, x);

    public static void main(String[] args) {
        int[][] matrix =
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };


        System.out.println(Arrays.deepToString(flipMatrix(matrix, FlipDirection.VERTICAL)));
    }

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {

        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Coordinates newCoordinates = transformer.transform(i, j);
                newMatrix[newCoordinates.getX()][newCoordinates.getY()] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int row;
                int column;
                if (flipDirection.equals(FlipDirection.HORIZONTAL)) {
                    row = i;
                    column = matrix.length - j - 1;
                } else {
                    column = j;
                    row = matrix.length - i - 1;
                }
                newMatrix[i][j] = matrix[row][column];
            }
        }
        return newMatrix;
    }


}
