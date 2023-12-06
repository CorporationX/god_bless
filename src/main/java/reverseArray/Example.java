package reverseArray;

import java.util.Arrays;

public class Example {
    public static int[] reverse(int[] array) {
        int[] reverseArray = Arrays.copyOf(array, array.length);
        int y = 0;
        for (int i = array.length - 1; i >= 0; i--, y++) {
            array[i] = reverseArray[y];
        }
        return array;
    }
}
