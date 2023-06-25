package faang.school.godbless.rotate_matrix;

import java.util.Arrays;

public class TransformProcessor {
    public enum FlipDirection {
        HORIZONTAL,
        VERTICAL,
    }

    static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int[][] tempMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                Coordinates newCoordinates = transformer.transform(i, j);
                tempMatrix[newCoordinates.getX()][newCoordinates.getY()] = matrix[i][j];
            }
        }
        return tempMatrix;
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        MatrixTransformer transformer;
        if(flipDirection == FlipDirection.VERTICAL) {
            transformer = ((x, y) -> new Coordinates(matrix.length - x - 1, y));
        } else {
            transformer = ((x, y) -> new Coordinates(x, matrix[0].length - y - 1));
        }
        return transformMatrix(matrix, transformer);
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.deepToString(flipMatrix(matrix, FlipDirection.HORIZONTAL)));
    }
}
