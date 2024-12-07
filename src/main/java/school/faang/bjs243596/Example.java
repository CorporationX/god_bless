package school.faang.bjs243596;

import java.util.Arrays;
import java.util.Collections;

public class Example {

    public static int[] reverseArray(int[] inputArray, int algoType) {
        validateEmptyArray(inputArray);

        switch (algoType) {
          case 1:
              int first = 0;
              int last = inputArray.length - 1;

              while (first < last) {
                  int oldRightValue = inputArray[first];
                  inputArray[first] = inputArray[last];
                  inputArray[last] = oldRightValue;
                  first++;
                  last--;
              }
              break;
          case 2:
              int arrayLength = inputArray.length;

              for (int i = 0; i < arrayLength / 2; i++) {
                  int oldValue = inputArray[i];
                  inputArray[i] = inputArray[arrayLength - i - 1];
                  inputArray[arrayLength - i - 1] = oldValue;
              }
              break;
          case 3:
              inputArray = Arrays.stream(inputArray)
                      .boxed().sorted(Collections.reverseOrder())
                      .mapToInt(Integer::intValue).toArray();
              break;
          default:
              Collections.reverse(Arrays.asList(inputArray));
              break;
        }

        return inputArray;
    }

    private static void validateEmptyArray(int[] inputArray) {
        if (inputArray == null || inputArray.length < 1) {
            throw new IllegalArgumentException("Input array cannot be empty!");
        }
    }
}
