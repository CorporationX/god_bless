package school.faang.bjs2_90600;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        System.out.println("Оригинальная матрица:");
        printMatrix(matrix);

        System.out.println("Горизонтальный переворот:");
        int[][] horizontalFlip = MatrixUtils.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        printMatrix(horizontalFlip);

        System.out.println("Вертикальный переворот:");
        int[][] verticalFlip = MatrixUtils.flipMatrix(matrix, FlipDirection.VERTICAL);
        printMatrix(verticalFlip);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }
}
