package faang.school.godbless.reversing;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Example {

    public static int[] reverse(int[] array) {
        if (array == null || array.length == 0) {
            log.warn("Processing denied. Array is empty.");
            return array;
        }
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
