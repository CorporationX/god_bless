package school.faang.task_bjs245602;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] newMatrix = MatrixProcessor.flipMatrix(matrix, FlipDirection.VERTICAL);
        printMatrix(newMatrix);

        System.out.println();

        int[][] newMatrix2 = MatrixProcessor.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        printMatrix(newMatrix2);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] value : matrix) {
            for (int i : value) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
