package revers;

import java.util.Arrays;

public class Example {

    public static int[] reverse(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int j = list.length - (i + 1);
            if (i >= j) {
                break;
            }

            int leftValue = list[i];
            list[i] = list[j];
            list[j] = leftValue;
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverse(new int[]{1, 2, 3, 4, 5})));
    }
}
