package faang.school.godbless.matrix;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;      //1 2 3
        matrix[0][1] = 2;      //3 4 5
        matrix[0][2] = 3;      //5 4 3
        matrix[1][0] = 3;
        matrix[1][1] = 4;
        matrix[1][2] = 5;
        matrix[2][0] = 5;
        matrix[2][1] = 4;
        matrix[2][2] = 3;

        matrix = MatrixManager.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("------------------");
        matrix = MatrixManager.flipMatrix(matrix, FlipDirection.VERTICAL);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
