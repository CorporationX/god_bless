package school.faang.revers;

import lombok.ToString;

@ToString
public class Example {
    public static int[] reverse(int[] array) {
        int iterations = array.length / 2;
        for (int i = 0; i < iterations; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }
}