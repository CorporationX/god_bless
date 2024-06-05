package faang.school.godbless;

import java.util.Arrays;

public class Example {
    public static int[] revers(int[] array) {
        int start = 0;
        int finish = array.length - 1;
        while (start < finish) {
            int temp = array[start];
            array[start++] = array[finish];
            array[finish--] = temp;
        }
        return array;
    }
}
