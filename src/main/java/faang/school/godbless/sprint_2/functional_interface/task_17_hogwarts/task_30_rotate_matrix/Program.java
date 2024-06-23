package faang.school.godbless.sprint_2.functional_interface.task_17_hogwarts.task_30_rotate_matrix;

import java.util.Arrays;

public class Program {

    public static void main(String[] args) throws IllegalAccessException {
        int m = 4;
        int n = 4;
        int[][] matrix = createMatrix(m, n);
        System.out.println("оригинальная матрица");
        printMatrix(matrix);

        System.out.println("Повёрнутая матрица по горизонтали");
        int[][] horizontalTransMatrix = flipMatrix(matrix, FlipDirection.HORIZONTAL);
        printMatrix(horizontalTransMatrix);

        System.out.println("Повёрнутая матрица по вертикали");
        int[][] verticalTransMatrix = flipMatrix(matrix, FlipDirection.VERTICAL);
        printMatrix(verticalTransMatrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static int[][] createMatrix(int m, int n) {
        int[][] matrix = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = count++;
            }
        }
        return matrix;
    }

    public static int[][] transformMatrix(int[][] matrix, MatrixTransformer transformer) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] transMatrix = new int[m][n];

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                Coordinates c = transformer.transform(new Coordinates(x, y));
                transMatrix[c.x()][c.y()] = matrix[x][y];
            }
        }
        return transMatrix;
    }

    public static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) throws IllegalAccessException {
        switch (flipDirection) {
            case VERTICAL -> {
                return transformMatrix(matrix, c -> new Coordinates(matrix.length - 1 - c.x(), c.y()));
            }
            case HORIZONTAL -> {
                return transformMatrix(matrix, c -> new Coordinates(c.x(), matrix.length - 1 - c.y()));
            }
            default -> throw new IllegalAccessException("Не существующий вариант поворота.");
        }
    }
}

enum FlipDirection {
    HORIZONTAL,
    VERTICAL,
}

