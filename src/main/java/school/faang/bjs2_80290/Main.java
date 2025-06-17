package school.faang.bjs2_80290;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 8},
        };
        System.out.println("Оригинальная матрица: ");
        MatrixUtils.print(matrix);
        System.out.println("Горизонтальный переворот: ");
        MatrixUtils.print(MatrixUtils.flipMatrix(matrix, FlipDirection.HORIZONTAL));
        System.out.println("Вертикальный переворот: ");
        MatrixUtils.print(MatrixUtils.flipMatrix(matrix, FlipDirection.VERTICAL));
    }


}
