package school.faang.unfold;

import java.util.Arrays;

public class Example {
    public static void main(String[] args) {

        int[] reverse = new int[]{1, 2, 3, 4, 5};

        for (int i = 0; i < reverse.length/2; i++) {
            int temp = reverse[i];
            reverse[i] = reverse[reverse.length - 1 - i];
            reverse[reverse.length - 1 - i] = temp;
        }

        System.out.println(Arrays.toString(reverse));

    }
}
