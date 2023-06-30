package Sprint_3_Task_Transfork_the_Matrix;
import java.util.Arrays;

public class Matrix {
    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                var newCoordinates = transformer.matrixTransforming(i, j);
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
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                int z;
                int a;

                if (flipDirection == FlipDirection.HORIZONTAL) {
                    z = i;
                    a = matrix[0].length - j - 1;
                } else {
                    z = j;
                    a = matrix.length - i - 1;
                }
                newMatrix[i][j] = matrix[z][a];
            }
        }
        return newMatrix;
    }

    public static void main(String[] args) {

        int[][] matrix = {{17, 27, 5, 7}, {37, 74, 7, 67}, {32, 41, 73, 7}};

        MatrixTransformer transformer = (x, y) -> new Coordinates(y, x);
        int[][] transformedMatrix = transformMatrix(matrix, transformer);
        System.out.println(Arrays.deepToString(transformedMatrix));

        FlipDirection flipDirection = FlipDirection.HORIZONTAL;
        int[][] flippedMatrix = flipMatrix(matrix, flipDirection);
        System.out.println(Arrays.deepToString(flippedMatrix));
    }
}
