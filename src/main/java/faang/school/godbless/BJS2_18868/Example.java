package faang.school.godbless.BJS2_18868;

import java.util.Arrays;
import java.util.Collections;

public class Example {
    public static void reverse(int[] array){
        for (int i = 0; i < array.length / 2; i++) {
            int firstElem = array[i];
            int lastElem = array[array.length - 1 - i];
            array[i] = lastElem;
            array[array.length - 1 - i] = firstElem;
        }
    }
}
