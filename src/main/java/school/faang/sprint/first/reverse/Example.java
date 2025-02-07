package school.faang.sprint.first.reverse;

import lombok.NonNull;

public class Example {
    public static int[] reverse(@NonNull int[] array) {
        int arrayLength = array.length;

        if (arrayLength == 0 || arrayLength == 1) {
            return array;
        }

        int[] tempArray = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            tempArray[i] = array[arrayLength - i - 1];
        }

        return tempArray;
    }
}
