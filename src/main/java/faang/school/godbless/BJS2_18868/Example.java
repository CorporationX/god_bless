package faang.school.godbless.BJS2_18868;

import java.util.Arrays;
import java.util.Collections;

public class Example {
    public static void reverse(int[] array){
        int size = array.length;
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[size - 1];
            array[size - 1] = temp;
            size--;
        }
    }
}
