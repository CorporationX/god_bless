package school.faang.sprint_2.task_45660;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        System.out.println("Оригинальная матрица:");
        printMatrix(matrix);

        int[][] horizontalFlip = MatrixUtils.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        System.out.println("Горизонтальный переворот:");
        printMatrix(horizontalFlip);

        int[][] verticalFlip = MatrixUtils.flipMatrix(matrix, FlipDirection.VERTICAL);
        System.out.println("Вертикальный переворот:");
        printMatrix(verticalFlip);

        MatrixTransformer rotateTransformer = (x, y) -> new Coordinates(y, x);
        int[][] transformedMatrix = MatrixUtils.transformMatrix(matrix, rotateTransformer);
        System.out.println("Преобразованная матрица:");
        printMatrix(transformedMatrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
