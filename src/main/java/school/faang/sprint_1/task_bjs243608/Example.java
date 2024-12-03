package school.faang.sprint_1.task_bjs243608;

import java.util.Arrays;

public class Example {

    public static void reverse(int[] array) {
        if (array == null) {
            return;
        }

        int leftIndex = 0;
        int rightIndex = array.length - 1;
        while (leftIndex < rightIndex) {
            int temp = array[leftIndex];
            array[leftIndex++] = array[rightIndex];
            array[rightIndex--] = temp;
        }
    }
}
