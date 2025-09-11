package school.faang.bjs2_87247;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        System.out.println("Original matrix");
        for (int[] one : matrix) {
            for (int two : one) {
                System.out.print(two + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------");

        int[][] horizontal = MatrixFlip.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        System.out.println("Horizontal matrix");
        for (int[] one : horizontal) {
            for (int two : one) {
                System.out.print(two + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------");
        System.out.println("Vertical matrix");
        int[][] vertical = MatrixFlip.flipMatrix(matrix, FlipDirection.VERTICAL);
        for (int[] one : vertical) {
            for (int two : one) {
                System.out.print(two + " ");
            }
            System.out.println();
        }
    }
}
