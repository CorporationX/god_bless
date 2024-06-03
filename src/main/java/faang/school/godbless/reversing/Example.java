package faang.school.godbless.reversing;

import java.util.Arrays;

public class Example {

    public static int[] reverse(int[] array) {
        int left = 0, right = array.length - 1;
        int[] reversedArray = Arrays.copyOf(array, array.length);
        while (left < right) {
            int temp = reversedArray[left];
            reversedArray[left] = reversedArray[right];
            reversedArray[right] = temp;
            left += 1;
            right -= 1;
        }
        return reversedArray;
    }
}
