package faang.school.godbless.reverse;

import java.util.Objects;

public class Example {

    public static int[] reverseArray(final int[] arr) {

        if (Objects.equals(arr, null)) {
            throw new IllegalArgumentException("Input array is null!");
        }

        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        return arr;
    }
}
