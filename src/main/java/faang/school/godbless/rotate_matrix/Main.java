package faang.school.godbless.rotate_matrix;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] resultMatrix = MatrixOperations.flipMatrix(matrix, FlipDirection.VERTICAL);
        MatrixOperations.showMatrix(resultMatrix);
        System.out.println();


        resultMatrix = MatrixOperations.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        MatrixOperations.showMatrix(resultMatrix);
        System.out.println();


        resultMatrix = MatrixOperations.flipMatrix(matrix, FlipDirection.LEFT_ROTATE);
        MatrixOperations.showMatrix(resultMatrix);
        System.out.println();


        resultMatrix = MatrixOperations.flipMatrix(matrix, FlipDirection.RIGHT_ROTATE);
        MatrixOperations.showMatrix(resultMatrix);
        System.out.println();
    }

}
