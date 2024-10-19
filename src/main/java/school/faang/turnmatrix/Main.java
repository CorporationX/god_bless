package school.faang.turnmatrix;

import static school.faang.turnmatrix.Coordinates.flipMatrix;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        System.out.println("Оригинальная матрица:");
        printMatrix(matrix);

        System.out.println("Горизонтальный переворот:");
        int[][] horizontalFlip = flipMatrix(matrix, Coordinates.FlipDirection.HORIZONTAL);
        printMatrix(horizontalFlip);

        System.out.println("Вертикальный переворот:");
        int[][] verticalFlip = flipMatrix(matrix, Coordinates.FlipDirection.VERTICAL);
        printMatrix(verticalFlip);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
