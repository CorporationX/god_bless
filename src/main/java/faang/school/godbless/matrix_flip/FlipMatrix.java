package faang.school.godbless.matrix_flip;

import java.util.Arrays;

public class FlipMatrix {

    public static int[][] flipMatrix(int[][] matrix, MatrixTransformer transformer){
        if (matrix.length == 0) {
            return new int[0][0];
        }
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                Coordinate newCoordinate = transformer.transform(i, j);
                newMatrix[newCoordinate.getX()][newCoordinate.getY()] = matrix[i][j];
            }
        }

        Arrays.stream(newMatrix).map(Arrays::toString).forEach(System.out::println);

        return newMatrix;
    }

    private static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        if (flipDirection == FlipDirection.HORIZONTAL) {
            return flipMatrix(matrix, (x, y) -> new Coordinate(x, columns - 1 - y));
        } else
            return flipMatrix(matrix, (x, y) -> new Coordinate(rows - 1 - x, y));
    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };

        flipMatrix(array, FlipDirection.VERTICAL);
        flipMatrix(array, FlipDirection.HORIZONTAL);
    }
}
