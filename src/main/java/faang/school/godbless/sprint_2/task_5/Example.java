package faang.school.godbless.sprint_2.task_5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Example {
    public static int[] reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int x = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = x;
        }
        return array;
    }
}
