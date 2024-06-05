package faang.school.godbless.reverse;

import lombok.ToString;

import java.util.Arrays;

@ToString
public class Example {
    public static void reverse(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length / 2; i++) {
            sum = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = sum;
        }
        showAnArrayReverse(array);
    }

    public static void showAnArrayReverse(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
