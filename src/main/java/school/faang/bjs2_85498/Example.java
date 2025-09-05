package school.faang.bjs2_85498;

import java.util.Arrays;

public class Example {

    public static void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        System.out.println("Массив после инверсии: " + Arrays.toString(array));
    }
}
