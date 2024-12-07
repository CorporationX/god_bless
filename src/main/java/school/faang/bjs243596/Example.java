package school.faang.bjs243596;

import java.util.Arrays;
import java.util.Collections;

public class Example {
    public static int[] reverseArray(int[] inputArray) {
        validateEmptyArray(inputArray);

        Collections.reverse(Arrays.asList(inputArray));
        return inputArray;
    }

    public static int[] reverseArray(int[] inputArray, String isMostEfficient) {
        validateEmptyArray(inputArray);

        int first = 0;
        int last = inputArray.length - 1;

        while (first < last) {
            int oldRightValue = inputArray[first];
            inputArray[first] = inputArray[last];
            inputArray[last] = oldRightValue;
            first++;
            last--;
        }

        return inputArray;
    }

    public static int[] reverseArray(int[] inputArray, boolean useIteration) {
        validateEmptyArray(inputArray);

        int arrayLength = inputArray.length;

        for (int i = 0; i < arrayLength / 2; i++) {
            int oldValue = inputArray[i];
            inputArray[i] = inputArray[arrayLength - i - 1];
            inputArray[arrayLength - i - 1] = oldValue;
        }

        return inputArray;
    }

    public static int[] reverseArray(int[] inputArray, int useStream) {
        validateEmptyArray(inputArray);

        //Collections.reverse(Arrays.asList(inputArray));
        //return Arrays.stream(inputArray).mapToInt(Integer::intValue).toArray();
        return Arrays.stream(inputArray)
                .boxed().sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue).toArray();
    }

    private static void validateEmptyArray(int[] inputArray) {
        if (inputArray == null || inputArray.length < 1) {
            throw new IllegalArgumentException("Input array cannot be empty!");
        }
    }
}
