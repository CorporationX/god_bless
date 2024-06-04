package faang.school.godbless;

import java.util.stream.IntStream;

public class Example {

    public static int[] reverse(int[] array) {
        int lengthArray = array.length - 1;
        for(int i = 0; i < array.length/2; i++) {
            int temp = array[i];
            array[i] = array[lengthArray - i];
            array[lengthArray -  i] = temp;
        }
        return array;
    }
}
