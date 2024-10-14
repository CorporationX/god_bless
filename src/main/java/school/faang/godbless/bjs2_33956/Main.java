package school.faang.godbless.bjs2_33956;

public class Main {
    public static void main(String[] args) {
        int[][] matrix =
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };

        int[][] matrix2 =
                {
                        {1, 2},
                        {4, 5}
                };

        int[][] matrixVertical = MatrixManager.flipMatrix(matrix, MatrixManager.FlipDirection.VERTICAL);
        int[][] matrixHorizontal = MatrixManager.flipMatrix(matrix, MatrixManager.FlipDirection.HORIZONTAL);

        int[][] matrixVertical1 = MatrixManager.flipMatrix(matrix2, MatrixManager.FlipDirection.VERTICAL);
        int[][] matrixHorizontal1 = MatrixManager.flipMatrix(matrix2, MatrixManager.FlipDirection.HORIZONTAL);
    }
}
