package faang.school.godbless.sprint_3.matrix_reverse;

import java.util.Arrays;

public class MatrixReverser {
    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        Coordinates coordinates = transformer.change(2, 1);
        dataValidation(coordinates, matrix);
        int size = coordinates.getY() + 1;
        int[][] result = new int[size][];
        for (int i = 0; i < result.length; i++) {
            int[] firstMassive = Arrays.copyOfRange(matrix[i], 0, coordinates.getX() + 1);
            result[i] = firstMassive;
        }
        return result;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        if (matrix.length == 0) {
            throw new IllegalArgumentException("Empty massive");
        } else if (flipDirection == FlipDirection.HORIZONTAL) {
            for (int i = 0; i < matrix.length; i++) {
                int count = matrix[i].length - 1;
                for (int j = 0; j < matrix[i].length / 2; j++) {
                    int oldValue = matrix[i][j];
                    matrix[i][j] = matrix[i][count];
                    matrix[i][count] = oldValue;
                    --count;
                }
            }
            return matrix;
        }
        int count = matrix.length - 1;
        for (int j = 0; j < matrix.length / 2; j++) {
            int[] oldValue = matrix[j];
            matrix[j] = matrix[count];
            matrix[count] = oldValue;
            --count;
        }
        return matrix;
    }

    public static void dataValidation(Coordinates coordinates, int[][] matrix) {
        int numberX = coordinates.getX();
        int numberY = coordinates.getY();
        if (matrix.length == 0) {
            throw new IllegalArgumentException("Empty massive");
        } else if (numberY < 0 || numberY >= matrix.length) {
            throw new IllegalArgumentException("Wrong Y value");
        }
        for (int[] massive : matrix) {
            if (numberX < 0 || numberX >= massive.length) {
                throw new IllegalArgumentException("Wrong X value");
            }
        }
    }
}