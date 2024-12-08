package school.faang.task_43799;

public class Example {
    public static int[] reversArray(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Input array cannot be null.");
        } else if (array.length == 0) {
            return array;
        } else {
            for (int i = 0; i < (array.length - 1) / 2; i++) {
                int first = array[array.length - 1 - i];
                array[array.length - 1 - i] = array[i];
                array[i] = first;
            }
            return array;
        }
    }
}
