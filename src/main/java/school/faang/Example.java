package school.faang;

import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(reverse(myArray)));
    }

    public static int[] reverse(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("array == null");
        }

        if (array.length <= 1) {
            return array;
        }

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int leftToRight = array[left];
            array[left] = array[right];
            array[right] = leftToRight;
            left++;
            right--;
        }
        return array;
    }
}
