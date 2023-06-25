package Matrix;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        int[][] horizontalTurn = Matrix.flipMatrix(matrix, FlipDirection.HORIZONTAL);
        int[][] verticalTurn = Matrix.flipMatrix(matrix, FlipDirection.VERTICAL);
        System.out.println(Arrays.deepToString(horizontalTurn));
        System.out.println(Arrays.deepToString(verticalTurn));
    }
}
