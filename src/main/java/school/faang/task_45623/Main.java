package school.faang.task_45623;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Исходная матрица:");
        MatrixUtils.printMatrix(matrix);

        int[][] flippedHorizontally = MatrixUtils.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        System.out.println("\nПосле горизонтального переворота:");
        MatrixUtils.printMatrix(flippedHorizontally);

        int[][] flippedVertically = MatrixUtils.flipMatrix(matrix, FlipDirection.VERTICAL);
        System.out.println("\nПосле вертикального переворота:");
        MatrixUtils.printMatrix(flippedVertically);

        // Дополнительные тесты
        int[][] singleRowMatrix = {{1, 2, 3}};
        System.out.println("\nОднострочная матрица:");
        MatrixUtils.printMatrix(singleRowMatrix);
        System.out.println("\nПосле горизонтального переворота:");
        MatrixUtils.printMatrix(MatrixUtils.flipMatrix(singleRowMatrix, FlipDirection.HORIZONTAL));
        System.out.println("\nПосле вертикального переворота:");
        MatrixUtils.printMatrix(MatrixUtils.flipMatrix(singleRowMatrix, FlipDirection.VERTICAL));

        int[][] singleColumnMatrix = {
                {1},
                {2},
                {3}
        };
        System.out.println("\nОдноколоночная матрица:");
        MatrixUtils.printMatrix(singleColumnMatrix);
        System.out.println("\nПосле горизонтального переворота:");
        MatrixUtils.printMatrix(MatrixUtils.flipMatrix(singleColumnMatrix, FlipDirection.HORIZONTAL));
        System.out.println("\nПосле вертикального переворота:");
        MatrixUtils.printMatrix(MatrixUtils.flipMatrix(singleColumnMatrix, FlipDirection.VERTICAL));
    }
}
