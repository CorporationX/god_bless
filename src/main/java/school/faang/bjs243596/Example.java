package school.faang.bjs243596;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Example {
    public static Integer[] reverseArray(Integer[] inputArray) {
        validateEmptyArray(inputArray);

        Collections.reverse(Arrays.asList(inputArray));
        return inputArray;
    }

    public static int[] reverseArray(Integer[] inputArray, boolean useIteration) {
        validateEmptyArray(inputArray);

        int arrayLength = inputArray.length;
        int[] result = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            result[i] = inputArray[arrayLength - i - 1];
        }

        return result;
    }

    public static int[] reverseArray(Integer[] inputArray, int useStream) {
        validateEmptyArray(inputArray);

        Collections.reverse(Arrays.asList(inputArray));
        return Arrays.stream(inputArray).mapToInt(Integer::intValue).toArray();
    }

    private static void validateEmptyArray(Integer[] inputArray) {
        if (inputArray.length < 1) {
            throw new IllegalArgumentException("Input array cannot be empty!");
        }
    }
}
