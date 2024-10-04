package school.faang.unfold;

import java.util.Arrays;

public class Example {
    public static void main(String[] args) {

        int[] reverse = new int[]{1, 2, 3, 4, 5};
        int[] reversed = new int[reverse.length];

        for (int i = 0; i < reverse.length; i++) {
            reversed[i] = reverse[reverse.length - 1 - i];
        }

        System.out.println(Arrays.toString(reversed));

    }
}
