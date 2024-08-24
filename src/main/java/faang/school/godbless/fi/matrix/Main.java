package faang.school.godbless.fi.matrix;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer[][] matrix = new Integer[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        Integer[][] newMatrix = flipMatrix(matrix, FlipDirection.HORIZONTAL);

        for (Integer[] row : newMatrix) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println();

        newMatrix = flipMatrix(matrix, FlipDirection.VERTICAL);

        for (Integer[] row : newMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static Integer[][] transformMatrix(Integer[][] matrix, MatrixTransformer transformer) {
        Coordinates oldCoordinates = new Coordinates(matrix.length, matrix[0].length);

        Coordinates newCoordinates = transformer.transform(oldCoordinates.getX(), oldCoordinates.getY());

        Integer[][] newMatrix = new Integer[newCoordinates.getX()][newCoordinates.getY()];

        if (!newCoordinates.isSwappedToVertical()) {
            for (int i = 0; i < matrix.length; i++) {
                newMatrix[i] = reverseArray(matrix[i]);
            }
            return newMatrix;
        }

        return reverseArray(matrix);
    }

    private static Integer[][] flipMatrix(Integer[][] matrix, FlipDirection flipDirection) {
        MatrixTransformer matrixTransformer;

        if (flipDirection == FlipDirection.HORIZONTAL) {
            matrixTransformer = (Coordinates::new);
        } else {
            matrixTransformer = ((x, y) -> {
                Coordinates newCoordinates = new Coordinates(y, x);

                newCoordinates.setSwappedToVertical(true);

                return newCoordinates;
            });
        }

        return transformMatrix(matrix, matrixTransformer);
    }

    private static<T> T[] reverseArray(T[] array) {
        T[] reversedArray = Arrays.copyOf(array, array.length);

        for (int i = 0, y = reversedArray.length - 1; i < y; i++, y--) {
            T temp = reversedArray[i];
            reversedArray[i] = reversedArray[y];
            reversedArray[y] = temp;
        }

        return reversedArray;
    }

}
