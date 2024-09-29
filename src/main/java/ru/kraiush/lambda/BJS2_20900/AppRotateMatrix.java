package ru.kraiush.lambda.BJS2_20900;

import java.util.Arrays;
import java.util.Collections;

public class AppRotateMatrix {

    public static void main(String[] args) {

        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.print(String.join("", Collections.nCopies(80, "-")));
        System.out.println("\n <---      matrix      ---> \n" + Arrays.deepToString(arr));

        FlipDirection.RotateType typeFlip = FlipDirection.RotateType.LEFT;

        int[][] rotateMatrix = Rotate.flipMatrix(arr, typeFlip);

        System.out.println(" <--- rotate Matrix to left --->");
        System.out.println(Arrays.deepToString(rotateMatrix));

        System.out.println(" <--- rotate Matrix to right --->");
        typeFlip = FlipDirection.RotateType.RIGHT;
        rotateMatrix = Rotate.flipMatrix(arr, typeFlip);
        System.out.println(Arrays.deepToString(rotateMatrix));
        System.out.print(String.join("", Collections.nCopies(80, "-")));
    }
}
