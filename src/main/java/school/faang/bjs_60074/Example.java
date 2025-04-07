package school.faang.bjs_60074;

import java.util.Arrays;
import java.util.Collections;

public class Example {

    public static int[] reverse(int[] array) {
        return Arrays.stream(array).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(i -> i).toArray();
    }

    /*
    На всякий случай прилагаю императивный вариант решения.
     */
    public static int[] imperativeReverse(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }
}
