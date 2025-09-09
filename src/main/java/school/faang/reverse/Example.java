package school.faang.reverse;

import java.util.Arrays;

public class Example {
    public static void reverse(int[] array) {
        if (array == null || array.length <= 1) {
            System.out.println("\nМассив пустой или равен null");
            return;
        }

        for (int i = 0; i < array.length / 2; i++) {
            int value = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = value;
        }
    }

    public static void printArray(int[] array) {
        Arrays.stream(array)
                .mapToObj(numsArray -> numsArray + " ")
                .forEach(System.out::print);
    }
}