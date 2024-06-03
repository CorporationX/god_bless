package faang.school.godbless.reversing;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Example {

    public static int[] reverse(int[] array) {
        if (array == null || array.length == 0) {
            log.warn("Processing denied. Array is empty.");
            return array;
        }
        int left = 0, right = array.length - 1;
        int[] reversedArray = new int[array.length];
        while (left <= right) {
            reversedArray[left] = array[right];
            reversedArray[right] = array[left];
            left += 1;
            right -= 1;
        }
        return reversedArray;
    }
}
