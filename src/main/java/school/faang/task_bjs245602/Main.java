package school.faang.task_bjs245602;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] newMatrix = MatrixProcessor.flipMatrix(matrix, FlipDirection.VERTICAL);
        for (int[] value : newMatrix) {
            for (int j = 0; j < value.length; j++) {
                System.out.print(value[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        int[][] newMatrix2 = MatrixProcessor.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        for (int[] value : newMatrix2) {
            for (int j = 0; j < value.length; j++) {
                System.out.print(value[j] + " ");
            }
            System.out.println();
        }
    }
}
