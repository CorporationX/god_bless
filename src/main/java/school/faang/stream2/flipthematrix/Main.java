package school.faang.stream2.flipthematrix;

public class Main {
    public static void main(String[] args) {
        int[][] argument = {{1, 2}, {3, 4}};
        printMatrix(argument);
        printMatrix(MatrixTransformer.flipMatrix(argument, FlipDirection.HORIZONTAL));
        printMatrix(MatrixTransformer.flipMatrix(argument, FlipDirection.VERTICAL));
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
