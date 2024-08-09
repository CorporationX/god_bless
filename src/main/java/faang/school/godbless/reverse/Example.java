package faang.school.godbless.reverse;

import java.util.Objects;

public class Example {

    public static <T extends Number> T[] reverseArray(final T[] arr) {

        if (Objects.equals(arr, null)) {
            throw new IllegalArgumentException("Input array is null!");
        }

        for (int i = 0; i < arr.length / 2; i++) {
            T temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        return arr;
    }
}
