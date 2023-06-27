package faang.school.godbless.task.rotateMatrix;

import java.util.Arrays;

public class Main {

    public static int[][] getTransformedMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (matrix.length == 0) {
            return new int[0][0];
        }
        int smallestArrayLength = getSmallestArrayLength(matrix);
        MatrixTransformer transformer;
        switch (flipDirection) {
            case HORIZONTAL -> transformer = (x, y) -> new Coordinates(matrix.length - 1 - x, y);
            case VERTICAL -> transformer = (x, y) -> new Coordinates(x, smallestArrayLength - 1 - y);
            default -> throw new IllegalArgumentException("No operation for current flip direction");
        }
        return transformMatrix(matrix, transformer);
    }

    private static int getSmallestArrayLength(int[][] matrix) {
        int smallestArrayLength = matrix[0].length;
        for (int[] array : matrix) {
            if (smallestArrayLength > array.length) {
                smallestArrayLength = array.length;
            }
        }
        return smallestArrayLength;
    }


    private static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int smallestArrayLength = getSmallestArrayLength(matrix);

        int[][] transformedMatrix = new int[matrix.length][smallestArrayLength];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < smallestArrayLength; j++) {
                var coordinates = transformer.transform(i, j);
                transformedMatrix[coordinates.getX()][coordinates.getY()] = matrix[i][j];
            }
        }

        return transformedMatrix;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 3, 5},
                {7, 9, 123, 0},
                {14, 7, 30},
                {32432, 83, 92, 21, 347}
        };

        Arrays.stream(arr).forEach(array -> System.out.println(Arrays.toString(array)));
        System.out.println();
        Arrays.stream(getTransformedMatrix(arr, FlipDirection.HORIZONTAL)).forEach(array -> System.out.println(Arrays.toString(array)));
        System.out.println();
        Arrays.stream(getTransformedMatrix(arr, FlipDirection.VERTICAL)).forEach(array -> System.out.println(Arrays.toString(array)));
    }
}
