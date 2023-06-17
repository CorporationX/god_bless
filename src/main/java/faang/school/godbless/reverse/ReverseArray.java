package faang.school.godbless.reverse;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(reverse(numbers)));

    }

    public static int[] reverse(int[] ints) {
        int i = 0;
        int j = ints.length - 1;

        while (i <= j) {
            int left = ints[i];
            int right = ints[j];

            ints[i] = right;
            ints[j] = left;

            i++;
            j--;
        }
        return ints;
    }
}
