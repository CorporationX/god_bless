package school.faang.rotatingMatrix;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] myMatrix = {
                {1, 2, 3},
                {3, 4, 5},
                {5, 6, 7},
                {6, 7, 8}
        };
        System.out.println(Arrays.deepToString(Transformator.flipMatrix(myMatrix, Transformator.Direction.HORIZONTAL)));
        System.out.println(Arrays.deepToString(Transformator.flipMatrix(myMatrix, Transformator.Direction.VERTICAL)));
    }
}
