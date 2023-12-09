package faang.school.godbless.example;

import java.util.Arrays;

public class Example {

    public static int[] reverse(int[] array) {
        int[] reversedArray = Arrays.copyOf(array, array.length);

        for (int i = 0; i < array.length / 2; i++) {
            reversedArray[array.length - i - 1] = array[i];
            reversedArray[i] = array[array.length - i - 1];
        }

        return reversedArray;
    }
}
