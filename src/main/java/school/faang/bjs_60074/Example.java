package school.faang.bjs_60074;

import java.util.Arrays;
import java.util.Collections;

public class Example {

    public static int[] reverse(int[] array) {
        return Arrays.stream(array).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue).toArray();
    }

    /*
    На всякий случай прилагаю императивный вариант решения.
     */
    public static int[] imperativeReverse(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        return array;
    }
}
