package faang.school.godbless;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.lang.reflect.Array;

public class Example {

    public static void reverseArray(int[] array){
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
}