package faang.school.godbless.turn_matrix;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(flipMatrix(new int[][]{{1, 2}, {3, 4}}, FlipDirection.VERTICAL)));
        System.out.println(Arrays.deepToString(flipMatrix(new int[][]{{1, 2}, {3, 4}}, FlipDirection.HORIZONTAL)));
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        return switch (flipDirection) {
            case VERTICAL -> transformMatrix(matrix, (x, y) -> new Coordinates(x, matrix.length - y - 1));
            case HORIZONTAL -> transformMatrix(matrix, (x, y) -> new Coordinates(matrix.length - x - 1, y));
        };
    }

    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Coordinates coordinates = transformer.transform(i, j);
                result[coordinates.getX()][coordinates.getY()] = matrix[i][j];
            }
        }
        return result;
    }
}