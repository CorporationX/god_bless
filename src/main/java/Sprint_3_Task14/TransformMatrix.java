package Sprint_3_Task14;

import java.util.Arrays;

public class TransformMatrix {
    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer){
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                var newCoordinates = transformer.matrixTransformer(i, j);
                newMatrix[newCoordinates.getX()][newCoordinates.getY()] = matrix[i][j];
            }
        }
        return newMatrix;
    }
    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection){
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int[][] flipDirectionMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                int flippedRow;
                int flippedCol;
                if (flipDirection == FlipDirection.HORIZONTAL) {
                    flippedRow = i;
                    flippedCol = matrix[0].length - j -1;
                } else {
                    flippedRow = matrix.length - i -1;
                    flippedCol = j;
                }
                flipDirectionMatrix[i][j] = matrix[flippedRow][flippedCol];
            }
        }
        return flipDirectionMatrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {3, 4}};
        MatrixTransformer transformer = (x, y) -> new Coordinates(y, x);
        int[][] transformedMatrix = transformMatrix(matrix, transformer);
        System.out.println(Arrays.deepToString(transformedMatrix));

        FlipDirection flipDirection = FlipDirection.HORIZONTAL;
        int[][] flippedMatrix = flipMatrix(matrix, flipDirection);
        System.out.println(Arrays.deepToString(flippedMatrix));
    }
}
