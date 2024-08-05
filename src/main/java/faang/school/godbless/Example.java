package faang.school.godbless;

import lombok.ToString;

@ToString
class Example {
    static int[] reverse(int[] array) {
        int size = array.length;

        if (size == 0 || size == 1) {
            return array;
        }

        for (int i = 0; i < size/2; i++) {
            int value = array[i];
            array[i] = array[size - i - 1];
            array[size - i - 1] = value;
        }

        return array;
    }
}
