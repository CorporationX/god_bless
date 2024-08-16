package faang.school.godbless.BJS2_19159;

import java.util.Arrays;

public class Example {
    public static void reverse(int[] array) {
        int element;
        for (int i = 0; i < array.length / 2; i++) {
            element = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = element;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{11, 1, 5, 3, 4, 5, 6, 0, 44, 0, -23};
        reverse(array);
        System.out.println(Arrays.toString(array));
    }
}


